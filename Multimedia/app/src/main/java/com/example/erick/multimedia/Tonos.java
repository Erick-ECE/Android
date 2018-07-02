package com.example.erick.multimedia;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tonos extends AppCompatActivity {
    SoundPool soundPool;
    int s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonos);

        AudioAttributes aa = new AudioAttributes.Builder().
                setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).
                setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();

        soundPool = new SoundPool.Builder().setMaxStreams(10).
                setAudioAttributes(aa).build();

        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes aa = new AudioAttributes.Builder().
                    setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).
                    setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();

            soundPool = new SoundPool.Builder().setMaxStreams(10).
                    setAudioAttributes(aa).build();
        }else {
            soundPool =new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        }
        */


        //sonidos
        s1= soundPool.load(this,R.raw.t1,1);
        s2= soundPool.load(this,R.raw.t2,1);
        s3= soundPool.load(this,R.raw.t3,1);
        s4= soundPool.load(this,R.raw.t4,1);
        s5= soundPool.load(this,R.raw.t5,1);
        s6= soundPool.load(this,R.raw.t6,1);
        s7= soundPool.load(this,R.raw.t7,1);
        s8= soundPool.load(this,R.raw.t8,1);
        s9= soundPool.load(this,R.raw.t9,1);
        s10= soundPool.load(this,R.raw.t10,1);

    }

    public void playSound(View view){
        switch (view.getId()){
            case R.id.btn_tec1:
                soundPool.play(s1,1,1,0,0,1);
                break;
            case R.id.btn_tec2:
                soundPool.play(s2,1,1,0,0,1);
                break;
            case R.id.btn_tec3:
                soundPool.play(s3,1,1,0,0,1);
                break;
            case R.id.btn_tec4:
                soundPool.play(s4,10,10,0,0,1);
                break;
            case R.id.btn_tec5:
                soundPool.play(s5,10,10,0,0,1);
                break;
            case R.id.btn_tec6:
                soundPool.play(s6,10,10,0,0,1);
                break;
            case R.id.btn_tec7:
                soundPool.play(s7,10,10,0,0,1);
                break;
            case R.id.btn_tec8:
                soundPool.play(s8,10,10,0,0,1);
                break;
            case R.id.btn_tec9:
                soundPool.play(s9,10,10,0,0,1);
                break;
            case R.id.btn_tec10:
                soundPool.play(s10,10,10,0,0,1);
                break;

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy ();
        soundPool.release ();
        soundPool = null;
    }


}
