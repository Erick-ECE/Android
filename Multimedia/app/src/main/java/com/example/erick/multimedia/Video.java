package com.example.erick.multimedia;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video = findViewById(R.id.videoView);

        String ruta = "android.resource://"+ getPackageName() +"/"+R.raw.sugar;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        MediaController mc = new MediaController(this);
        video.setMediaController(mc);
        mc.setAnchorView(video);

    }
}
