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

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageButton playPauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.monetochka90);
        playPauseButton = findViewById(R.id.playButton);

    }

    public void magnify(View view) {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.animate().scaleY(1.5f).scaleX(1.5f).rotation(360).setDuration(1000);
        imageView.animate().scaleY(1).scaleX(1).rotation(360).setDuration(1000);
    }

    public void previous(View view) {
    }

    public void next(View view) {
    }

    public void play(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playPauseButton.setImageResource(R.drawable.play_arrow);
        }else {
            mediaPlayer.start();
            playPauseButton.setImageResource(R.drawable.pause);
        }
    }
}
