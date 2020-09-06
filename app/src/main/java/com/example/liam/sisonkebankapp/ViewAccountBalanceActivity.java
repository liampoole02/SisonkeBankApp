package com.example.liam.sisonkebankapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewAccountBalanceActivity extends AppCompatActivity {
    TextView labelviewbalance;
    TextView labelholdername;
    TextView labelholdersurname;
    TextView labelsavingsbalance;
    TextView labelcurrentbalance;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewaccountbalance);

        labelviewbalance=findViewById(R.id.textviewview);
        labelholdername=findViewById(R.id.textviewholdername);
        labelholdersurname=findViewById(R.id.textviewholdersurname);
        labelcurrentbalance=findViewById(R.id.textviewholdercurrentbalance);
        labelsavingsbalance=findViewById(R.id.textviewsavingsbalance);

    }
}
