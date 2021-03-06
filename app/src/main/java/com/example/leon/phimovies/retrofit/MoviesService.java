package com.example.leon.phimovies.retrofit;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Leon on 29.01.2016.
 */
public interface MoviesService {

    @GET("/3/discover/movie")
    Call<ApiResults> getInTheaters(
            @Query("primary_release_date.gte") String dateGte,
            @Query("primary_release_date.lte") String dateLte,
            @Query("page") String page,
            @Query("api_key") String apiKey);

    @GET("/3/discover/movie")
    Call<ApiResults> getPopular(
            @Query("sort_by") String sortBy,
            @Query("page") String page,
            @Query("api_key") String apiKey);

    @GET("/3/search/movie")
    Call<ApiResults> getSearchResult(
            @Query("query") String query,
            @Query("page") String page,
            @Query("api_key") String apiKey);

}
