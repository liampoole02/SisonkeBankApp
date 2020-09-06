package com.example.liam.sisonkebankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText loginUsername;
    EditText loginPassword;
    TextView loginRegisterLink;
    Button loginLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUsername=findViewById(R.id.edittextusername);
        loginPassword=findViewById(R.id.edittextpassword);
        loginLogin=findViewById(R.id.buttonlogin);
        loginRegisterLink=findViewById(R.id.textviewregister);

        loginRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent registerIntent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        loginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent=new Intent(MainActivity.this, MainPageActivity.class);
                startActivity(registerIntent);
            }
        });

    }
}