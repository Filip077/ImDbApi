package com.example.korisnik.imdbapi.RecylerAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.korisnik.imdbapi.Model.Movies;
import com.example.korisnik.imdbapi.Model.Search;
import com.example.korisnik.imdbapi.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korisnik on 16.03.2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Search> movies;
    private Context context;

    public Adapter(List<Search> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Search movie = movies.get(position);

        holder.title.setText(movie.getTitle());
        holder.type.setText(movie.getType());
        holder.year.setText(movie.getYear());

        Picasso.with(context).load(movie.getPoster()).into(holder.poster);


    }

    @Override
    public int getItemCount() {
        return movies==null ? 0 : movies.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView poster;
        private TextView title , year,type;
        public ViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            title = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);
            type = itemView.findViewById(R.id.type);
        }
    }
}
