package com.example.liam.sisonkebankapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    private User user;

    double currentAccountBalance;
    double savingsAccountBalance;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        transferlabel=findViewById(R.id.textviewtransferlabel);
        currentbalance=findViewById(R.id.textviewcurrentbalancetransfer);
        savingsbalance=findViewById(R.id.textviewsavingsbalancetransfer);
        enteramountlabel=findViewById(R.id.textviewentertransferamount);
        transferamount=findViewById(R.id.registeredittextlastname);
        spinner=findViewById(R.id.spinner);

        currentAccountBalance=0;
        savingsAccountBalance=0;

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.transferoptions, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        buttontransfer=findViewById(R.id.buttontransfer);

        db=new DatabaseHelper(this);
        user=new User();

        final String emailFromIntent = getIntent().getStringExtra("EMAIL");

        final Cursor cursor=db.getUserDetails(emailFromIntent);

        while(cursor.moveToNext()){
            currentbalance.setText("Current Account Balance: "+cursor.getString(6));
            currentAccountBalance=Double.parseDouble(cursor.getString(6));
            savingsbalance.setText("Savings Account balance: "+cursor.getString(7));
            savingsAccountBalance=Double.parseDouble(cursor.getString(7));

        }

        buttontransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

                if (transferamount.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a transfer amount", Toast.LENGTH_LONG).show();
                } else {

                    if (spinner.getSelectedItem().toString().trim().equals("Current to savings")) {
                        if (Integer.parseInt(transferamount.getText().toString().trim()) > currentAccountBalance) {
                            Toast.makeText(getApplicationContext(), "You cannot transfer more than what you have, please choose a smaller amount", Toast.LENGTH_LONG).show();
                        } else {
                            user.setCurrentAccountBal(currentAccountBalance-Double.parseDouble(transferamount.getText().toString().trim()));
                            user.setSavingsAccountBal(savingsAccountBalance+Double.parseDouble(transferamount.getText().toString().trim()));
                            user.setUserEmail(emailFromIntent);

                            db.updateBalance(user);
                            Toast.makeText(getApplicationContext(), "Your transfer has compeleted successfully", Toast.LENGTH_LONG).show();

                            Intent registerIntent = new Intent(TransferActivity.this, TransferActivity.class);
                            registerIntent.putExtra("EMAIL", emailFromIntent);
                            startActivity(registerIntent);
                        }

                    } else if(spinner.getSelectedItem().toString().trim().equals("Savings to current")) {
                        if (Integer.parseInt(transferamount.getText().toString().trim()) > savingsAccountBalance) {
                            Toast.makeText(getApplicationContext(), "You cannot transfer more than what you have, please choose a smaller amount", Toast.LENGTH_LONG).show();
                        } else {
                            user.setSavingsAccountBal(savingsAccountBalance-Double.parseDouble(transferamount.getText().toString().trim()));
                            user.setCurrentAccountBal(currentAccountBalance+Double.parseDouble(transferamount.getText().toString().trim()));
                            user.setUserEmail(emailFromIntent);

                            db.updateBalance(user);
                            Toast.makeText(getApplicationContext(), "Your transfer has completed successfully", Toast.LENGTH_LONG).show();

                            Intent registerIntent = new Intent(TransferActivity.this, TransferActivity.class);
                            registerIntent.putExtra("EMAIL", emailFromIntent);

                            startActivity(registerIntent);
                        }
                    }
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(getApplicationContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getApplicationContext(), "No Option selected", Toast.LENGTH_LONG).show();

    }
}
