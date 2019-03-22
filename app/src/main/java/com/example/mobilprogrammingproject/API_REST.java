package com.example.mobilprogrammingproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_REST{
    String URL = "https://raw.githubusercontent.com/Zatuar/MobilProgrammingProject/Listv2/data/";

    @GET("3A_2018_2019.json")
    Call<List<Individu>> loadChanges();
}
