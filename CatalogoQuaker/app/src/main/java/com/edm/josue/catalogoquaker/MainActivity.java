package com.edm.josue.catalogoquaker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //Oculta los menus de default de android y hace la app full screen
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //Obtiene la fecha actual de la tableta
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());
        String[] separatedDate = formattedDate.split("-");

        //Obtengo el mes y el año
        int month = Integer.parseInt(separatedDate[1]);
        int year = Integer.parseInt(separatedDate[2]);

        //Referencia al video
        final VideoView videoScreenSaver = (VideoView) findViewById(R.id.ScreenSaver);
        String uriVideo = "";

        //checa la fecha de la tableta y muestra el screen saver correspondiente
        if ((month >= 9 && year == 2018) || (month >= 1 && year > 2018))
            uriVideo = "android.resource://com.edm.josue.catalogoquaker/" + R.raw.screensaver;
        else
            uriVideo = "android.resource://com.edm.josue.catalogoquaker/" + R.raw.screensaver;

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

        //Boton invisible para salir del screen saver
        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
            }
        });
    }
}
