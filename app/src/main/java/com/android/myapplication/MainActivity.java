package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext()); // For VERTICAL list view of items
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false); // for HORIZONTAL list view of items
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL)); // Adding lines between items change it to VERTICAL when you use VERTICAL list view
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() { // Adding Listener to each item
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is clicked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Avengers: Endgame", "Superhero", "2019");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible – Fallout", "Action", "2018");
        movieList.add(movie);

        movie = new Movie("The Fountain", "Drama & Fantasy", "2006");
        movieList.add(movie);

        movie = new Movie("Deadpool", "Superhero & Action", "2016");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("X-Men: Dark Phoenix", "Superhero & Action", "2019");
        movieList.add(movie);

        movie = new Movie("Avatar", "Science-fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The Matrix", "Action", "1999");
        movieList.add(movie);

        movie = new Movie("Interstellar", "Science-fiction", "2014");
        movieList.add(movie);

        movie = new Movie("Inception", "Science-fiction", "2010");
        movieList.add(movie);

        movie = new Movie("Fight Club", "Drama", "1999");
        movieList.add(movie);

        movie = new Movie("The Good, the Bad and the Ugly", "Western", "1966");
        movieList.add(movie);

        movie = new Movie("The Godfather", "Drama/Crime", "1972");
        movieList.add(movie);

        movie = new Movie("For a Few Dollars More", "Western", "1965");
        movieList.add(movie);

        movie = new Movie("Legend", "Drama/Crime", "2015");
        movieList.add(movie);

        movie = new Movie("James Bond - Casino Royale", "Mystery/Thriller", "2006");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}