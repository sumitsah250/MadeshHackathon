package com.courseitem;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.boss.edutech.R;

public class MockTest extends AppCompatActivity {
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mock_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dialog= new ProgressDialog(this);
        dialog.setMessage("Preparing Test for you >>>");
        dialog.setCancelable(false);
        dialog.show();
        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // Action after successful load
                dialog.dismiss();
//                Toast.makeText(MockTest.this, "Page Loaded Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.tcyonline.com/tests/entrance-exam");

    }
}