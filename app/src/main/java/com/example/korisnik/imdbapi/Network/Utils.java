package com.example.korisnik.imdbapi.Network;

import com.example.korisnik.imdbapi.Model.Movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Korisnik on 16.03.2018.
 */

public interface Utils {
    @GET("http://www.omdbapi.com/")
    Call <Movies> getMovies(@Query("s")String s,
                            @Query("apikey") String apikey);
}
