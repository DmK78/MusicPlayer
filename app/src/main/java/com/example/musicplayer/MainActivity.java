package com.example.musicplayer;

import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageButton playPauseButton;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.monetochka90);
        playPauseButton = findViewById(R.id.playButton);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 1000);

    }

    public void magnify(View view) {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.animate().scaleY(1.5f).scaleX(1.5f).rotation(360).setDuration(1000);
        imageView.animate().scaleY(1).scaleX(1).rotation(360).setDuration(1000);
    }

    public void previous(View view) {
        mediaPlayer.seekTo(0);
        seekBar.setProgress(0);
        mediaPlayer.pause();
        playPauseButton.setImageResource(R.drawable.play_arrow);
    }

    public void next(View view) {
        mediaPlayer.seekTo(mediaPlayer.getDuration());
        seekBar.setProgress(mediaPlayer.getDuration());
        playPauseButton.setImageResource(R.drawable.play_arrow);
    }

    public void play(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playPauseButton.setImageResource(R.drawable.play_arrow);
        } else {
            mediaPlayer.start();
            playPauseButton.setImageResource(R.drawable.pause);
        }
    }
}
