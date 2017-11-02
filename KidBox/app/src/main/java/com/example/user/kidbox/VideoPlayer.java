package com.example.user.kidbox;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("flag");


        VideoView v = (VideoView) findViewById(R.id.videoView);
        v.setVideoURI(Uri.parse("android.resource://com.example.user.kidbox/raw/"+str));
        v.setMediaController(new MediaController(this));
        v.requestFocus();
        v.start();


        /*setVolumeControlStream(AudioManager.STREAM_MUSIC);
        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {

            MediaPlayer mp = new MediaPlayer();
            mp.setDataSource("android.resource://com.example.user.kidbox/raw/coldplaylyrics.mp4");
            mp.prepareAsync();
            mp.start();

            Uri video = Uri.parse("android.resource://com.example.user
            .kidbox/raw/coldplaylyrics");

            Uri video = Uri.parse(path);
            mediaPlayer.setDataSource("android.resource://com.example.user" +
                    ".kidbox/raw/coldplaylyrics.mp4");
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();

                }
            });
        } catch (IOException e) {
            Log.d("NOPEEEE", e.toString());
            e.printStackTrace();
        }*/
    }
}
