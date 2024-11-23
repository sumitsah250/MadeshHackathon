package com.boss.chat;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.edutech.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{
    private ArrayList<ChatMessage> chatList;
    private Context context;

    public ChatAdapter(ArrayList<ChatMessage> chatList, Context context) {
        this.chatList = chatList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatMessage chatMessage = chatList.get(position);
        holder.chatMessage.setText(chatMessage.getMessage());

        // Align based on sender/receiver
        LinearLayout.LayoutParams params =
                (LinearLayout.LayoutParams) holder.chatMessage.getLayoutParams();

        if (chatMessage.isSender()) {
            params.gravity = Gravity.END;
            holder.chatMessage.setBackgroundResource(R.drawable.sender_background);
        } else {
            params.gravity = Gravity.START;
            holder.chatMessage.setBackgroundResource(R.drawable.reciever_background);
        }

        holder.chatMessage.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView chatMessage;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            chatMessage = itemView.findViewById(R.id.chatMessage);
        }
    }
}
