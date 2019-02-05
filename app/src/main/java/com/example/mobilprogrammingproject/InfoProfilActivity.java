package com.example.mobilprogrammingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoProfilActivity extends AppCompatActivity {
    private static final String NAME = "His_name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_profil);
        showNameProfil();
    }
    public void showNameProfil(){
        TextView Name = (TextView) findViewById(R.id.profil_id);
        Name.setText(NAME);
    }
}
