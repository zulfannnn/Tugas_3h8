package com.example.assignment_3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://651ebf3344a3a8aa4768ed57.mockapi.io/api/mocksample/";

    @GET("covid-info")
    Call<List<Covid>> getAllcovidinfo();
}
