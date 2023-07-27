package com.example.parcial_jamir_balcona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CRUD extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserListAdapter userListAdapter;
    private List<HelperClass> userList;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        // Agregar el ValueEventListener para escuchar los cambios en la base de datos.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    HelperClass user = snapshot.getValue(HelperClass.class);
                    userList.add(user);
                }
                userListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        userListAdapter = new UserListAdapter(this, userList, new UserListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HelperClass user) {
                // Abre la actividad para editar el usuario seleccionado.
                Intent intent = new Intent(CRUD.this, EditUserActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(userListAdapter);

        findViewById(R.id.addUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre la actividad para agregar un nuevo usuario.
                Intent intent = new Intent(CRUD.this, AddUserActivity.class);
                startActivity(intent);
            }
        });
    }
}
