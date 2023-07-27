package com.example.parcial_jamir_balcona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {
    TextView txtNombre, txtUsuario, txtEdad, txtDNI, txtRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        txtNombre = findViewById(R.id.bienvenida);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtEdad = findViewById(R.id.txtEdad);
        txtDNI = findViewById(R.id.txtDNI);
        txtRegion = findViewById(R.id.txtRegion);

        String name = getIntent().getStringExtra("name");
        String username = getIntent().getStringExtra("username");
        String dni = getIntent().getStringExtra("dni");
        String edad = getIntent().getStringExtra("edad");
        String nacimiento = getIntent().getStringExtra("nacimiento");

        txtNombre.setText(name);
        txtUsuario.setText(username);
        txtEdad.setText(edad);
        txtDNI.setText(dni);
        txtRegion.setText(nacimiento);

    }
}