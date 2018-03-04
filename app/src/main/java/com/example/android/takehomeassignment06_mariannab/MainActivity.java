package com.example.android.takehomeassignment06_mariannab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submitReceipt(View view) {

        double amountEntered;
        double taxPercentage;
        double tipPercentage;

        EditText amount = (EditText) findViewById(R.id.amount_entered);
        String enteredAmount = amount.getText().toString();
        amountEntered = Double.parseDouble(enteredAmount);

        EditText tax = (EditText) findViewById(R.id.tax_percentage);
        String taxEntered = tax.getText().toString();
        taxPercentage = Double.parseDouble(taxEntered);


        EditText tip = (EditText) findViewById(R.id.tip_percentage);
        String tipEntered = tip.getText().toString();
        tipPercentage = Double.parseDouble(tipEntered);

        TipCalculator myTip = new TipCalculator(amountEntered, taxPercentage, tipPercentage);

        Intent intent = new Intent(this, ReceiptActivity.class);
        intent.putExtra(Keys.TIP_KEY, myTip);
        startActivity(intent);

    }
}
