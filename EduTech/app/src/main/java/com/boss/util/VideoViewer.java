package com.boss.util;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.boss.edutech.R;

public class VideoViewer extends AppCompatActivity {

    String videoUrl ;
    VideoView videoView ;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_viewer);

        intent = getIntent();


        videoUrl = intent.getStringExtra("videourl");
        videoView = findViewById(R.id.idVideoView);



        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);


        CustomMediaController customMediaController = new CustomMediaController(this);


        customMediaController.setFullscreenToggleListener(new CustomMediaController.FullscreenToggleListener() {
            @Override
            public void onFullscreenToggle(boolean isFullscreen) {
                if (isFullscreen) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
            }
        });

        customMediaController.setAnchorView(videoView);
        customMediaController.setMediaPlayer(videoView);
        videoView.setMediaController(customMediaController);

        videoView.start();








    }
}