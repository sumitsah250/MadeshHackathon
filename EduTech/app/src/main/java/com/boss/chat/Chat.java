package com.boss.chat;

import android.content.res.Configuration;
import android.os.Bundle;

import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.edutech.databinding.ActivityChatBinding;

import com.boss.edutech.R;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Chat extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityChatBinding binding;

    private RecyclerView chatRecyclerView;
    private ChatAdapter chatAdapter;
    private ArrayList<ChatMessage> chatList;
    private EditText messageInput;
    private Button sendButton;
    private ExecutorService executor;
    private GenerativeModel gm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);


        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);

        // Initialize chat list and adapter
        chatList = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatList, this);

        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatRecyclerView.setAdapter(chatAdapter);

        // Add initial messages
        chatList.add(new ChatMessage("Do You need Help !! Tell me what you need , I am here !", false));

        // Initialize GenerativeModel
        try {
            gm = new GenerativeModel(
                    "gemini-1.5-flash-001",
                    "AIzaSyA3MOfaAcvIMdT6kMIOSYUEDr3kjnzGneQ"
            );
        } catch (Exception e) {
            Log.e("Chat", "GenerativeModel initialization failed", e);
//            Toast.makeText(this, "AI Model Initialization Failed", Toast.LENGTH_LONG).show();
            return; // Exit if initialization fails
        }


        // Send button functionality
        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();

            if (!message.isEmpty()) {
                chatList.add(new ChatMessage(message, true));
                chatAdapter.notifyItemInserted(chatList.size() - 1);
                chatRecyclerView.scrollToPosition(chatList.size() - 1);
                messageInput.setText("");

                sendMessageToGemini(message);
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_chat);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void sendMessageToGemini(String userMessage) {
        if (userMessage.isEmpty()) {
            return;
        }

        // Add the user message to the chat list
        // True for sender
        chatAdapter.notifyItemInserted(chatList.size() - 1);
        chatRecyclerView.scrollToPosition(chatList.size() - 1);

        // Build the content for AI response
        Content content = new Content.Builder()
                .addText(userMessage)
                .build();

        // Create the response future
        GenerativeModelFutures model = GenerativeModelFutures.from(gm);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        ListenableFuture<GenerateContentResponse> response = model.generateContent(content);

        // Handle response
        Futures.addCallback(response, new FutureCallback<GenerateContentResponse>() {
            @Override
            public void onSuccess(GenerateContentResponse result) {
                String resultText = result.getText();

                runOnUiThread(() -> {
                    // Add AI response to the chat list
                    chatList.add(new ChatMessage(resultText, false)); // False for receiver
                    chatAdapter.notifyItemInserted(chatList.size() - 1);
                    chatRecyclerView.scrollToPosition(chatList.size() - 1);
                });
            }

            @Override
            public void onFailure(Throwable t) {


                runOnUiThread(() ->
                        Toast.makeText(Chat.this, "Failed to get response from Gemini", Toast.LENGTH_SHORT).show());
            }
        }, executor);

        // Shut down the executor after response
        response.addListener(() -> executor.shutdown(), executor);
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}