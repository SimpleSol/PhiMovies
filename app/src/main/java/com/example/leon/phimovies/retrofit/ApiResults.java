package com.example.leon.phimovies.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Leon on 29.01.2016.
 */
public class ApiResults {

    @SerializedName("results")
    private List<Movie> mMovies;

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }

}
