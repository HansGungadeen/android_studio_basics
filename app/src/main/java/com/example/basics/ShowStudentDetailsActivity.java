package com.example.basics;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

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

public class ShowStudentDetailsActivity extends AppCompatActivity {

    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<StudentDetails> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_details);

        //recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowStudentDetailsActivity.this));
        //progressDialog - status of operation
        progressDialog = new ProgressDialog(ShowStudentDetailsActivity.this);
        progressDialog.setMessage("Loading Data From Firebase Database");
        progressDialog.show();
        //get instance of table
        databaseReference = FirebaseDatabase.getInstance().getReference(MainActivity3.Database_Path);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    StudentDetails studentDetails = dataSnapshot.getValue(StudentDetails.class);
                    list.add(studentDetails);
                }
                adapter = new RecyclerViewAdapter(ShowStudentDetailsActivity.this,list);
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ShowStudentDetailsActivity.this,"Database error", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();

            }
        });

    }
}