package com.example.mobilprogrammingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.String;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.mobilprogrammingproject.API_REST.URL;

public class ListActivity extends AppCompatActivity {
    List<Individu> student;
    RecyclerView mClassList;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        start();
    }
    public void start(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        API_REST response = retrofit.create(API_REST.class);
        Call<List<Individu>> call = (response).loadChanges();
        call.enqueue(new Callback<List<Individu>>() {
            @Override
            public void onResponse(Call<List<Individu>> call, Response<List<Individu>> response) {
                student=response.body();
                showStudent();
            }

            @Override
            public void onFailure(Call<List<Individu>> call, Throwable t) {
                Log.d("ERROR", "API ERROR");
            }
        });
    }
    public void showStudent() {
        mClassList = findViewById(R.id.classList);
        mClassList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mClassList.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(student, new OnItemClickListener() {
            @Override
            public void onItemClick(Individu item) {
                selectMe(item);
            }
        });
        mClassList.setAdapter(mAdapter);
    }
    public void selectMe(Individu item){
        Intent selectStudent = new Intent(this, InfoProfilActivity.class);
        Gson gson = new Gson();
        String jsonInString = gson.toJson(item);
        selectStudent.putExtra("Student",jsonInString);
        startActivity(selectStudent);
    }
}

