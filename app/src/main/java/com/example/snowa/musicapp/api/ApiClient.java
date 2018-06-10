package com.example.snowa.musicapp.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("track.php")
    Call<Tracks> getTrack(@Query("h") int trackId);

    @GET("trending.php")
    Call<TrendingList> getTrendingList(@Query("country") String country, @Query("type")
            String type, @Query("format") String format);

}

