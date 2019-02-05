package com.example.mobilprogrammingproject;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface API_REST{

    public static final String URL = "https://api.github.com";

    @GET("/users/{user}/repos")
    void listReposAsync(@Path("user") String user, Callback<List<individu>> callback);
    //List<individu> listRepos(@Path("user") String user);

    @GET("/search/repositories")
    List<individu> searchRepos(@Query("q") String query);
}
