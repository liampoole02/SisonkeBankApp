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

//        final String emailFromIntent = getIntent().getStringExtra("EMAIL");

        Cursor cursor=db.getUserDetails(MainPageActivity.email);

        while(cursor.moveToNext()){
            labelholdername.setText("Account Holder name: "+cursor.getString(2));
            labelholdersurname.setText("Account Holder surname: "+cursor.getString(3));
            labelcurrentbalance.setText("Current Account Balance: R"+Double.parseDouble(cursor.getString(6)));
            labelsavingsbalance.setText("Savings Account balance: R"+Double.parseDouble(cursor.getString(7)));
        }

    }
}
