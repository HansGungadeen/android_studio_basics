package com.example.basics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {

    //Declaring String Variable
    Button SubmitButton;
    EditText NameEditText, PhoneNumberEditText;

    //Declaring String variable ( In which we are storing firebase server URL ).
    public static final String Firebase_Server_URL = "https://polyblog-eb474-default-rtdb.firebaseio.com/";

    //declare String variable to store Name & Phone Number to get from EditText
    String NameHolder, NumberHolder;

    Firebase firebase;

    DatabaseReference databaseReference;

    //root database Name for firebase database
    public static final String Database_Path = "Student_Details_Database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Firebase.setAndroidContext(MainActivity3.this);
        firebase = new Firebase(Firebase_Server_URL);
        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        SubmitButton = (Button)findViewById(R.id.submit);
        //get data from name_field to here
        NameEditText = (EditText)findViewById(R.id.name);
        //get data from phone_field to here
        PhoneNumberEditText = (EditText)findViewById(R.id.phone_number);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentDetails studentDetails = new StudentDetails();
                //data from field to String
                GetDataFromEditText();
                //Adding name into class function object.
                studentDetails.setStudentName(NameHolder);
                //Adding phone number into class function object.
                studentDetails.setStudentPhoneNumber(NumberHolder);
                // Getting the ID from firebase database.
                String StudentRecordIDFromServer = databaseReference.push().getKey();
                // Adding the both name and number values using student details class object using ID.
                databaseReference.child(StudentRecordIDFromServer).setValue(studentDetails);
                // Showing Toast message after successfully data submit.
                Toast.makeText(MainActivity3.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();
            } });

    }

    public void GetDataFromEditText(){
        NameHolder = NameEditText.getText().toString().trim();
        NumberHolder = PhoneNumberEditText.getText().toString().trim();
    }
}
