package com.example.liam.sisonkebankapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainPageActivity extends AppCompatActivity {

    TextView welcome;
    Button btnviewbalance;
    Button btntransfer;
    Button btnlogout;
    Toolbar toolbar;

    DatabaseHelper db;
     static String email;
    private User user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        welcome=findViewById(R.id.registertextviewlabel);
        btnviewbalance=findViewById(R.id.mainpageviewbalance);
        btntransfer=findViewById(R.id.mainpagetransfer);
        btnlogout=findViewById(R.id.mainpagelogout);

        db=new DatabaseHelper(this);

        email = getIntent().getStringExtra("EMAIL");

        user=db.getUserDetails(email);

        welcome.setText("Welcome "+user.getUserName());

        btnlogout.setOnClickListener(new View.OnClickListener() {//Logs user out
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(),"You have been logged out", Toast.LENGTH_LONG).show();

            }
        });

        btnviewbalance.setOnClickListener(new View.OnClickListener() {//Takes user to ViewBalanceActivity
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPageActivity.this, ViewAccountBalanceActivity.class);
                startActivity(intent);
            }
        });

        btntransfer.setOnClickListener(new View.OnClickListener() {//Takes user to Transfer activity
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPageActivity.this, TransferActivity.class);

                startActivity(intent);
            }
        });
    }
}