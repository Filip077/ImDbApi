package com.example.korisnik.imdbapi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.korisnik.imdbapi.Model.Movies;
import com.example.korisnik.imdbapi.Model.Search;
import com.example.korisnik.imdbapi.Network.Utils;
import com.example.korisnik.imdbapi.RecylerAdapter.Adapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayMovies extends AppCompatActivity {
        private static final String BASE_URL = "http://www.omdbapi.com/";
        private static final String TAG = DisplayMovies.class.getSimpleName();
        private RecyclerView recyclerView;
        private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies);
        recyclerView = findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(new GridLayoutManager(DisplayMovies.this,2));
        recyclerView.setAdapter(adapter);
        Bundle i = getIntent().getExtras();
        String movie = i.getString("movie");

        getMovies(movie);
    }


    public void getMovies(String movie){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        if(BuildConfig.DEBUG){
            client.addInterceptor(interceptor);
        }

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build());
        Retrofit retrofit = builder.build();
        Utils utils = retrofit.create(Utils.class);
        Call <Movies> call = utils.getMovies(movie,"9e08c64f");

        call.enqueue(new Callback <Movies>() {
            @Override
            public void onResponse(Call <Movies> call, Response <Movies> response) {
            if(!response.isSuccessful() || response.body() == null){
                Toast.makeText(DisplayMovies.this, "Failed to get movies.", Toast.LENGTH_SHORT).show();
            }
            else {
                Movies jsonResponse = response.body();
                ArrayList<Search> data = new ArrayList<>(Arrays.asList(jsonResponse.getSearch()));
                recyclerView.setAdapter(new Adapter(data,getApplicationContext()));
            }
            }

            @Override
            public void onFailure(Call <Movies> call, Throwable t) {
                Toast.makeText(DisplayMovies.this, "Failed to make connection", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
