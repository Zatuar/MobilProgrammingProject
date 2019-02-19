package com.example.mobilprogrammingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class InfoProfilActivity extends AppCompatActivity {
    private String student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_profil);
        student = getIntent().getStringExtra("Student");
        show();
    }
    public void show(){
        Gson gson = new Gson();
        Individu student = gson.fromJson(this.student, Individu.class);
        TextView nameView = findViewById(R.id.profil_name);
        nameView.setText(getString(R.string.profil_name, student.getName()));
        TextView firstNameView = findViewById(R.id.profil_firstName);
        firstNameView.setText(getString(R.string.profil_name, student.getPrenom()));
        TextView surnameView = findViewById(R.id.profil_surname);
        surnameView.setText(getString(R.string.profil_name, student.getSurnom()));
        TextView emailView = findViewById(R.id.profil_email);
        emailView.setText(getString(R.string.profil_name, student.getEmail()));
    }
}
