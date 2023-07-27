package com.example.parcial_jamir_balcona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class acercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        ImageView imageView = findViewById(R.id.img);
        Glide.with(this)
                .load(R.drawable.perrito)
                .into(imageView);

    }

    public void onSalirClicked(View view) {
        Intent intent = new Intent(acercaDe.this, MainActivity.class);
        startActivity(intent);
    }
}
