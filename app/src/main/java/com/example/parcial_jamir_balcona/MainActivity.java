package com.example.parcial_jamir_balcona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CardView calculadora, ilo, acercade, perfil;

    TextView bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bienvenida = findViewById(R.id.bienvenida);
        calculadora = findViewById(R.id.calculadora);
        ilo = findViewById(R.id.ilo);
        acercade = findViewById(R.id.acercade);
        perfil = findViewById(R.id.perfil);

        // Obtén el los datos del usuario del intent
        String name = getIntent().getStringExtra("name");
        String dni = getIntent().getStringExtra("dni");
        String username = getIntent().getStringExtra("username");
        String edad = getIntent().getStringExtra("edad");
        String nacimiento = getIntent().getStringExtra("nacimiento");

        // Muestra el mensaje de bienvenida con el nombre de usuario
        String welcomeMessage = "Bienvenido " + name;
        bienvenida.setText(welcomeMessage);

        calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CRUD.class);
                startActivity(intent);
            }
        });


        acercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, acercaDe.class);
                startActivity(intent);
            }
        });
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Perfil.class);
                intent.putExtra("name", name);
                intent.putExtra("dni", dni);
                intent.putExtra("username", username);
                intent.putExtra("edad", edad);
                intent.putExtra("nacimiento", nacimiento);
                startActivity(intent);
            }
        });

    }
}