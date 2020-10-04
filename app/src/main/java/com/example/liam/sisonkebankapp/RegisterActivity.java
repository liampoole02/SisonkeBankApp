package com.example.liam.sisonkebankapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    TextView registerenterlabel;

    EditText registerfirstname;
    EditText registerlastname;
    EditText registeremail;
    EditText registerpassword;
    EditText registermobile;

    Button registerbutton;
    DatabaseHelper databaseHelper;

    private User user;

    double currentaccount;
    double savingsaccount;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHelper=new DatabaseHelper(this);
        user=new User();

        registerenterlabel=findViewById(R.id.registertextviewlabel);

        registerfirstname=findViewById(R.id.registeredittextfirstname);
        registerlastname=findViewById(R.id.registeredittextlastname);
        registeremail=findViewById(R.id.registeredittextemail);
        registerpassword=findViewById(R.id.registeredittextpassword);
        registermobile=findViewById(R.id.registeredittextmobile);

        registerbutton=findViewById(R.id.registerbuttoncreate);

          currentaccount=5000;
          savingsaccount=2000;

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=registeremail.getText().toString().trim();
                String password=registerpassword.getText().toString().trim();
                String name=registerfirstname.getText().toString().trim();
                String surname=registerlastname.getText().toString().trim();
                String mobile=registermobile.getText().toString().trim();

                if(email.equals("")||password.equals("")||name.equals("")||surname.equals("")||mobile.equals("")){
                    Toast.makeText(getApplicationContext(),"Please fill in all the fields", Toast.LENGTH_LONG).show();
                }if(password.length()<5){
                    Toast.makeText(getApplicationContext(),"Password has to be longer than 5 characters", Toast.LENGTH_LONG).show();
                }

                else{
                        Boolean checkEmail=databaseHelper.checkEmail(email);
                        if(checkEmail==true){
                            user.setUserEmail(email);
                            user.setUserPassword(password);
                            user.setUserName(name);
                            user.setUserSurname(surname);
                            user.setUserMobile(mobile);
                            user.setCurrentAccountBal(currentaccount);
                            user.setSavingsAccountBal(savingsaccount);

                            databaseHelper.addUser(user);

                                Toast.makeText(getApplicationContext(),"You have been registered successfully", Toast.LENGTH_LONG).show();
                                Intent registerIntent=new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(registerIntent);

                        }else{
                            Toast.makeText(getApplicationContext(),"This email already exists", Toast.LENGTH_LONG).show();
                        }
                    }

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
    }
