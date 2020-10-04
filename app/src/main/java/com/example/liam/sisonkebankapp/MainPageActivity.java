package com.example.liam.sisonkebankapp;

import android.content.Intent;
import android.database.Cursor;
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

    DatabaseHelper db;
    private User user;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        welcome=findViewById(R.id.registertextviewlabel);
        btnviewbalance=findViewById(R.id.mainpageviewbalance);
        btntransfer=findViewById(R.id.mainpagetransfer);
        btnlogout=findViewById(R.id.mainpagelogout);


        db=new DatabaseHelper(this);
        user=new User();

        final String emailFromIntent = getIntent().getStringExtra("EMAIL");

        Cursor cursor=db.getUserDetails(emailFromIntent);

        while(cursor.moveToNext()){
            welcome.setText("Welcome "+cursor.getString(2));
        }

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnviewbalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPageActivity.this, ViewAccountBalanceActivity.class);
                intent.putExtra("EMAIL", emailFromIntent);
                startActivity(intent);
            }
        });

        btntransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainPageActivity.this, TransferActivity.class);
                intent.putExtra("EMAIL", emailFromIntent);
                startActivity(intent);
            }
        });
    }
}