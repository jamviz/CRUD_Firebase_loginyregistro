package com.example.parcial_jamir_balcona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText signupName, signupDNI, signupUsername, signupPassword, signupEdad;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    Spinner lugarNacimientoSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupName = findViewById(R.id.signup_name);
        signupDNI = findViewById(R.id.signup_dni);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupEdad = findViewById(R.id.signup_edad);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        lugarNacimientoSpinner = findViewById(R.id.signup_lugar_nacimiento);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.regiones_peru, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lugarNacimientoSpinner.setAdapter(adapter);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String dni = signupDNI.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String edad = signupEdad.getText().toString();
                String nacimiento = lugarNacimientoSpinner.getSelectedItem().toString();

                HelperClass helperClass = new HelperClass(name, dni, username, password, edad, nacimiento);
                reference.child(username).setValue(helperClass);

                Toast.makeText(SignupActivity.this, "Te registraste satisfactoriamente!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
