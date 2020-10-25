package com.example.liam.sisonkebankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText loginUsername;
    EditText loginPassword;
    TextView loginRegisterLink;
    Button loginLogin;

    private User user;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);
        user=new User();

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
                String email=loginUsername.getText().toString().toLowerCase().trim();
                String password=loginPassword.getText().toString().trim();

                //Validates fields
                if(email.equals("")||password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill in all required fields", Toast.LENGTH_LONG).show();
                }else if(password.length()<5){
                    Toast.makeText(getApplicationContext(), "Passwords has to be more than 5 characters", Toast.LENGTH_LONG).show();
                }else {
                    //When fields are filled in properly


                    Boolean check=db.emailPassword(email, password); //Validates login details

                    if(check==false) {
                        Toast.makeText(getApplicationContext(), "Incorrect email or password", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();

                        Intent registerIntent = new Intent(MainActivity.this, MainPageActivity.class);
                        registerIntent.putExtra("EMAIL", email);

                        loginUsername.setText("");
                        loginPassword.setText("");

                        startActivity(registerIntent);
                    }
                }
            }
        });

    }
}