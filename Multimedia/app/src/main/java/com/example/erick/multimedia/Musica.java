package com.example.erick.multimedia;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Musica extends AppCompatActivity {
    Button pp,stop;
    Drawable pause,play;
    boolean click = true;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        stop= findViewById(R.id.btn_stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });
    }

    public void playToPause(View view){
        pp = findViewById(R.id.btn_pp);
        pause = getDrawable(R.drawable.icn_pause);
        play = getDrawable(R.drawable.play_icon);


        if (mp == null){
            mp = MediaPlayer.create(this,R.raw.wiky);
        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        if(click){
            pp.setBackground(pause);
            click = !click;
            mp.start();
        }else if (!click){
            pp.setBackground(play);
            click = !click;
            mp.pause();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void stop(){
        if (mp != null){
            mp.release();
            mp = null;
            Toast.makeText(this,"Media Player Liberado",Toast.LENGTH_SHORT).show();
        }

    }
}
