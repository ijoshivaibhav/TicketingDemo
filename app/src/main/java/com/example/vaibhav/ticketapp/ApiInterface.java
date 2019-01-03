package com.example.vaibhav.ticketapp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

//    https://api.androidhive.info/json/movies.json
    /*

    @FormUrlEncoded
    @POST("/demo/login.php")
    public ArrayList<MoviePojo> getMovieData();
*/

    String BASE_URL="https://api.androidhive.info/json/";

    @GET("movies.json")
    Call<List<MoviePojo>> getHeroes();

}
