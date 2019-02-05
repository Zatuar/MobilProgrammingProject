package com.example.mobilprogrammingproject;
import java.util.List;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface API_REST{

    public static final String URL = "https://api.github.com";

    @GET("/users/{user}/repos")
    Response listRepos(@Path("user") String user);

    @GET("/search/repositories")
    List<individu> searchRepos(@Query("q") String query);
}
