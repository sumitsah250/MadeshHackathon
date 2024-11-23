package com.boss.util;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;

import com.boss.edutech.R;

public class CustomMediaController extends MediaController {
    private ImageButton fullscreenButton;
    private boolean isFullscreen = false;
    private FullscreenToggleListener fullscreenToggleListener;

    public CustomMediaController(Context context) {
        super(context);
    }

    @Override
    public void setAnchorView(View view) {
        super.setAnchorView(view);

        // Add a fullscreen button
        fullscreenButton = new ImageButton(getContext());
        fullscreenButton.setImageResource(R.drawable.ic_fullscreen); // Add fullscreen icon to drawable

        // Set button click listener
        fullscreenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                isFullscreen = !isFullscreen;
                fullscreenButton.setImageResource(isFullscreen ? R.drawable.ic_exitfullscreen : R.drawable.ic_fullscreen);
                if (fullscreenToggleListener != null) {
                    fullscreenToggleListener.onFullscreenToggle(isFullscreen);
                }
            }
        });

        // Add the fullscreen button to the MediaController
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        params.rightMargin = 20;
        params.bottomMargin = 20;
        addView(fullscreenButton, params);
    }

    public void setFullscreenToggleListener(FullscreenToggleListener listener) {
        this.fullscreenToggleListener = listener;
    }

    public interface FullscreenToggleListener {
        void onFullscreenToggle(boolean isFullscreen);
    }
}
