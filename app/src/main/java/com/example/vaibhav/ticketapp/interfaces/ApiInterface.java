package com.example.vaibhav.ticketapp.interfaces;

import com.example.vaibhav.ticketapp.models.MoviePojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

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
