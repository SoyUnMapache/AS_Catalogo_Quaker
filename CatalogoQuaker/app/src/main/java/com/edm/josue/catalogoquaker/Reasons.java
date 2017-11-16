package com.edm.josue.catalogoquaker;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.VideoView;

public class Reasons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reasons);

        //Oculta los menus de default de android y hace la app full screen
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //Referencia al video
        final VideoView videoScreenSaver = (VideoView) findViewById(R.id.videoReasons);
        String uriVideo = "android.resource://com.edm.josue.catalogoquaker/" + R.raw.razones;

        //Carga y reproduce el video el video
        Uri uri2 = Uri.parse(uriVideo);
        videoScreenSaver.setVideoURI(uri2);
        videoScreenSaver.requestFocus();
        videoScreenSaver.start();

        //Repite el video cuando se termina
        videoScreenSaver.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoScreenSaver.start();
            }
        });

        //Repite el video cuando se termina
        videoScreenSaver.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoScreenSaver.start();
            }
        });

        //region EVENTO BOTONES
        Button btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
            }
        });

        Button btnBenefits = (Button) findViewById(R.id.btnBenefits);
        btnBenefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Benefits.class);
                startActivity(intent);
            }
        });
        //endregion
    }
}
