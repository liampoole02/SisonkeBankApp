package com.example.liam.sisonkebankapp;

import android.os.Bundle;
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

    }
}