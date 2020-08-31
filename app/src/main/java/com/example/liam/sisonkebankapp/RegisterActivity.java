package com.example.liam.sisonkebankapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    TextView registerenterlabel;

    EditText registerfirstname;
    EditText registerlastname;
    EditText registeremail;
    EditText registerpassword;
    EditText registermobile;

    Button registerbutton;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerenterlabel=findViewById(R.id.registertextviewlabel);
        registerfirstname=findViewById(R.id.registeredittextfirstname);
        registerlastname=findViewById(R.id.registeredittextlastname);
        registeremail=findViewById(R.id.registeredittextemail);
        registerpassword=findViewById(R.id.registeredittextpassword);
        registermobile=findViewById(R.id.registeredittextmobile);

        registerbutton=findViewById(R.id.registerbuttoncreate);

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
