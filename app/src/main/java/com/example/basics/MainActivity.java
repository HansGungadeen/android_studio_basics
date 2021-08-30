package com.example.basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button, button_3, go_to_recycler, fragment_test_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button_3 = (Button) findViewById(R.id.button_3);
        go_to_recycler = (Button) findViewById(R.id.go_to_recycler);
        fragment_test_btn = (Button) findViewById(R.id.fragment_test_btn);

        fragment_test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragmentTuto();
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });

        go_to_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

    }

    private void openFragmentTuto() {
        Intent intent = new Intent(this, fragmentTuto.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }


}