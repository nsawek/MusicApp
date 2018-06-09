package com.example.snowa.musicapp.topsongs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.snowa.musicapp.R;

public class SongDetailsActivity extends AppCompatActivity {

    public static final String TRACK = "track";
    public static final String ARTIST = "artist";
    public static final String TRACK_ID = "track_id";

    String track;
    String artist;
    int trackId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        track = getIntent().getStringExtra(TRACK);
        artist = getIntent().getStringExtra(ARTIST);
        trackId = getIntent().getIntExtra(TRACK_ID, -1);

        getSupportActionBar().setTitle(track);
        getSupportActionBar().setSubtitle(artist);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

