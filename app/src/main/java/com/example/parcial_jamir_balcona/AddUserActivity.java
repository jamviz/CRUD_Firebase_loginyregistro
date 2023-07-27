package com.example.parcial_jamir_balcona;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddUserActivity extends AppCompatActivity {

    private EditText firstNameET, lastNameET, phoneET, bioET;
    private Button addUserBtn;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        firstNameET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        phoneET = findViewById(R.id.phoneET);
        bioET = findViewById(R.id.bioET);
        addUserBtn = findViewById(R.id.addUser);

        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    private void addUser() {
        String firstName = firstNameET.getText().toString();
        String lastName = lastNameET.getText().toString();
        String phone = phoneET.getText().toString();
        String bio = bioET.getText().toString();

        String username = lastName; // Utilizamos el apellido como el username en este caso.

        HelperClass newUser = new HelperClass(firstName, phone, username, "", "", bio);
        databaseReference.child(username).setValue(newUser);

        finish(); // Vuelve a la actividad anterior después de agregar el usuario.
    }
}
