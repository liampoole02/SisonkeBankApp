package com.example.liam.sisonkebankapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewAccountBalanceActivity extends AppCompatActivity {
    TextView labelviewbalance;
    TextView labelholdername;
    TextView labelholdersurname;
    TextView labelsavingsbalance;
    TextView labelcurrentbalance;
    DatabaseHelper db;
    private User user;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewaccountbalance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        labelviewbalance=findViewById(R.id.textviewview);
        labelholdername=findViewById(R.id.textviewholdername);
        labelholdersurname=findViewById(R.id.textviewholdersurname);
        labelcurrentbalance=findViewById(R.id.textviewholdercurrentbalance);
        labelsavingsbalance=findViewById(R.id.textviewsavingsbalance);

        db=new DatabaseHelper(this);
        user=new User();


        User user=db.getUserDetails(MainPageActivity.email);

        //Displays information in the fields
            labelholdername.setText("Account Holder name: "+user.getUserName());
            labelholdersurname.setText("Account Holder surname: "+user.getUserSurname());
            labelcurrentbalance.setText("Current Account Balance: R"+user.getCurrentAccountBal());
            labelsavingsbalance.setText("Savings Account balance: R"+user.getSavingsAccountBal());


    }
}
