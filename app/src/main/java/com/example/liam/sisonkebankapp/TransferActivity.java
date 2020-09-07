package com.example.liam.sisonkebankapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TransferActivity  extends AppCompatActivity {
    TextView transferlabel;
    TextView currentbalance;
    TextView savingsbalance;
    TextView enteramountlabel;

    EditText transferamount;

    Spinner spinner;

    Button buttontransfer;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        transferlabel=findViewById(R.id.textviewtransferlabel);
        currentbalance=findViewById(R.id.textviewcurrentbalancetransfer);
        savingsbalance=findViewById(R.id.textviewsavingsbalancetransfer);
        enteramountlabel=findViewById(R.id.textviewentertransferamount);

        transferamount=findViewById(R.id.registeredittextlastname);

        spinner=findViewById(R.id.spinner);

        buttontransfer=findViewById(R.id.buttontransfer);

    }

}
