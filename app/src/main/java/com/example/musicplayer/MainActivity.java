package com.example.musicplayer;

import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void magnify(View view) {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.animate().scaleY(1.5f).scaleX(1.5f).rotation(360).setDuration(1000);
        imageView.animate().scaleY(1).scaleX(1).rotation(360).setDuration(1000);
    }
}
