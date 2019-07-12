package com.fpt.weatherapp.Network;



import com.fpt.weatherapp.Model.Wheather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    String BASE_URL = "http://dataservice.accuweather.com";

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Wheather>> gethour();

    @GET("/forecasts/v1/daily/5day/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Wheather>> getDay();
}

//dWRGN2tbGw1zakCXdAnkGLedzbBFcXHG