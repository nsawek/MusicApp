package com.example.snowa.musicapp.topsongs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.snowa.musicapp.R;
import com.example.snowa.musicapp.api.ApiService;
import com.example.snowa.musicapp.api.TrendingList;
import com.example.snowa.musicapp.api.TrendingSingle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSongsActivity extends AppCompatActivity {
    RecyclerView rvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_songs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvList = findViewById(R.id.rvList);
        Call<TrendingList> trendingListCall = ApiService.getService().getTrendingList("us",
                "itunes", "singles");
        trendingListCall.enqueue(new Callback<TrendingList>()

        {
            @Override
            public void onResponse(@NonNull Call<TrendingList> call, @NonNull
                    Response<TrendingList> response) {
                TrendingList trendingList = response.body();

                if (trendingList != null && trendingList.trending​ != null) {
                    setList(trendingList.trending​);
                }
            }

            @Override
            public void onFailure(@NonNull Call<TrendingList> call, Throwable t) {
                Toast.makeText(TopSongsActivity.this, "Blad pobierania danych: " +
                        t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setList(List<TrendingSingle> singles) {
        TopSongsAdapter topSongsAdapter = new TopSongsAdapter(singles);
        rvList.setAdapter(topSongsAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        rvList.getAdapter().notifyDataSetChanged();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
