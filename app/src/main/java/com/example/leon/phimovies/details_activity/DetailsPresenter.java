package com.example.leon.phimovies.details_activity;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.leon.phimovies.retrofit.Movie;

/**
 * @author Leon
 */
public class DetailsPresenter {

    private final DetailsView mView;

    private final Context mContext;

    @Nullable
    private Movie mMovie;

    public DetailsPresenter(@NonNull DetailsView view, @NonNull Context context) {
        mView = view;
        mContext = context;
    }

    public void saveToDataBase() {
        if (mMovie != null) {
            ContentValues newValues = new ContentValues();
            newValues.put(Movie.Columns.API_ID, mMovie.getmApiId());
            newValues.put(Movie.Columns.TITLE, mMovie.getTitle());
            newValues.put(Movie.Columns.OVERVIEW, mMovie.getOverview());
            newValues.put(Movie.Columns.POSTER, mMovie.getPoster());
            newValues.put(Movie.Columns.RATING, mMovie.getRating());
            newValues.put(Movie.Columns.RELEASE_DATE, mMovie.getReleaseDate());
            newValues.put(Movie.Columns.IS_SHOWING, Movie.TRUE);

            mContext.getContentResolver().insert(Movie.URI, newValues);
        }
    }

    public void initMovieData(Movie movie) {
        mMovie = movie;
        Uri uri = Uri.parse("http://image.tmdb.org/t/p/w300" + movie.getPoster());
        mView.showMovieInfo(uri, movie);
    }
}
