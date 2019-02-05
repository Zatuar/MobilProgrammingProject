package com.example.mobilprogrammingproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.String;
import java.net.URL;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListActivity extends AppCompatActivity {
    private RecyclerView mClassList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] prenoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        API_REST githubService = new RestAdapter.Builder()
                .setEndpoint(API_REST.URL)
                .build()
                .create(API_REST.class);

        githubService.listReposAsync("Zatuar",new Callback<List<individu>>() {
            @Override
            public void success(List<individu> repos, Response response) {
                afficherRepos(repos);
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
        chargefile();
    }

    public void afficherRepos(List<individu> repos) {
        Toast.makeText(this,"nombre de dépots : "+repos.size(),Toast.LENGTH_SHORT).show();
    }
    public void chargefile(){
        prenoms = new String[]{
                "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
                "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan", "Mathieu",
                "Noemie", "Olivia", "Philippe", "Quentin", "Romain", "Sophie", "Tristan",
                "Ulric", "Vincent", "Willy", "Xavier", "Yann", "Zoé"
        };

        mClassList = (RecyclerView) findViewById(R.id.classList);
        mClassList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mClassList.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(prenoms);
        mClassList.setAdapter(mAdapter);
    }
    }

