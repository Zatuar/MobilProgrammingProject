package com.example.mobilprogrammingproject;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.InputStream;


public class InfoProfilActivity extends AppCompatActivity {
    private String student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_profil);
        student = getIntent().getStringExtra("Student");
        show();
    }

    public void show() {
        Gson gson = new Gson();
        Individu student = gson.fromJson(this.student, Individu.class);

        if(!student.getPicture().isEmpty()){
            new DownloadImageTask((ImageView) findViewById(R.id.picture)).execute(student.getPicture());
        }else{
            ImageView imageView=findViewById(R.id.picture);
            imageView.setImageResource(R.drawable.mort);
        }

        TextView nameView = findViewById(R.id.profil_name);
        setFont(nameView, "sevesbrg.ttf");
        nameView.setText(getString(R.string.profil_name, student.getName() + " " + student.getPrenom()));
        TextView surnameView = findViewById(R.id.profil_surname);
        setFont(surnameView, "sevesbrg.ttf");
        surnameView.setText(getString(R.string.profil_name, student.getSurnom()));
        TextView emailView = findViewById(R.id.profil_email);
        setFont(emailView, "sevesbrg.ttf");
        emailView.setText(getString(R.string.profil_name, student.getEmail()));

    }

    public void setFont(TextView textView, String fontName) {
        if (fontName != null) {
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "font/" + fontName);
                textView.setTypeface(typeface);
            } catch (Exception e) {
                Log.e("FONT", fontName + " not found", e);
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
