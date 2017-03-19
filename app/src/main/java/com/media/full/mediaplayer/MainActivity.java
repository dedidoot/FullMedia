package com.media.full.mediaplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.exoplayer2.demo.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * TEST Video BROH
         * */
        Uri uri = Uri.parse("https://github.com/dedy99/FullMedia/blob/mastermu/KOES%20PLUS%20Bujangan.mp4?raw=true");

        String path = Environment.getExternalStorageDirectory().getPath();
        String pathMp4 = path + "/Download/sunsetanarki.mp4";

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(uri); // jika url dari online / web services
        //videoView.setVideoPath(pathMp4);// jika url dari local device

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
        videoView.start();

        /**
         * TEST MP3 BROH
         * */
        String pathMp3 = path + "/Download/sampah.mp3";
        Uri uriMp3LocaLDevice = Uri.parse(pathMp3);
        Uri uriMp3Online = Uri.parse("https://raw.githubusercontent.com/dedy99/FullMedia/mastermu/Jamrud-surti%20tejo%20(www.savelagu.eu).mp3");
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, uriMp3Online);
        Button btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        Button btnPause = (Button) findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });


    }

}
