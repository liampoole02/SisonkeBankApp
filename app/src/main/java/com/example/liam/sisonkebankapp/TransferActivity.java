package com.example.liam.sisonkebankapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TransferActivity  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView transferlabel;
    TextView currentbalance;
    TextView savingsbalance;
    TextView enteramountlabel;

    EditText transferamount;

    Spinner spinner;

    Button buttontransfer;
    DatabaseHelper db;
    User user;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        transferlabel=findViewById(R.id.textviewtransferlabel);
        currentbalance=findViewById(R.id.textviewcurrentbalancetransfer);
        savingsbalance=findViewById(R.id.textviewsavingsbalancetransfer);
        enteramountlabel=findViewById(R.id.textviewentertransferamount);

        transferamount=findViewById(R.id.registeredittextlastname);

        spinner=findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.transferoptions, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        buttontransfer=findViewById(R.id.buttontransfer);

        db=new DatabaseHelper(this);
        user=new User();

        final String emailFromIntent = getIntent().getStringExtra("EMAIL");

        Cursor cursor=db.getUserDetails(emailFromIntent);

        while(cursor.moveToNext()){
            currentbalance.setText("Current Account Balance: "+cursor.getString(5));
            savingsbalance.setText("Savings Account balance: "+cursor.getString(6));
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
