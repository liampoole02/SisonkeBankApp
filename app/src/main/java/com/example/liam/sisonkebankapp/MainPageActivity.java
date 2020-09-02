package com.example.liam.sisonkebankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPageActivity extends AppCompatActivity {

    TextView welcome;
    Button btnviewbalance;
    Button btntransfer;
    Button btnlogout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        welcome=findViewById(R.id.registertextviewlabel);
        btnviewbalance=findViewById(R.id.mainpageviewbalance);
        btntransfer=findViewById(R.id.mainpagetransfer);
        btnlogout=findViewById(R.id.mainpagelogout);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}