package com.example.parcial_jamir_balcona;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditUserActivity extends AppCompatActivity {

    private EditText firstNameET, lastNameET, phoneET, bioET;
    private Button saveBtn, deleteBtn;
    private DatabaseReference databaseReference;
    private HelperClass user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        firstNameET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        phoneET = findViewById(R.id.phoneET);
        bioET = findViewById(R.id.bioET);
        saveBtn = findViewById(R.id.save);
        deleteBtn = findViewById(R.id.delete);

        // Obtener el usuario seleccionado de la actividad anterior.
        user = getIntent().getParcelableExtra("user");
        if (user != null) {
            firstNameET.setText(user.getName());
            lastNameET.setText(user.getUsername());
            phoneET.setText(user.getDNI());
            bioET.setText(user.getNacimiento());
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser();
            }
        });
    }

    private void updateUser() {
        String firstName = firstNameET.getText().toString();
        String lastName = lastNameET.getText().toString();
        String phone = phoneET.getText().toString();
        String bio = bioET.getText().toString();

        user.setName(firstName);
        user.setUsername(lastName);
        user.setDNI(phone);
        user.setNacimiento(bio);

        databaseReference.child(user.getUsername()).setValue(user);
        finish(); // Vuelve a la actividad anterior después de editar el usuario.
    }

    private void deleteUser() {
        databaseReference.child(user.getUsername()).removeValue();
        finish(); // Vuelve a la actividad anterior después de eliminar el usuario.
    }
}