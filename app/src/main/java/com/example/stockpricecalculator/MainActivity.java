package com.example.stockpricecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;


public class MainActivity extends AppCompatActivity {

    EditText  edtOriginalPrice, edtAmountBought, edtSellingPrice;
    TextView txtPercentIncrease, txtProfit, txtTotalProfit;
    Button btnCalculate, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        buttonLogic();
    }

    private void buttonLogic(){

        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);

        txtPercentIncrease = findViewById(R.id.txtPercentIncrease);
        txtProfit = findViewById(R.id.txtProfit);
        txtTotalProfit = findViewById(R.id.txtTotalProfit);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateLogic();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearLogic();
            }
        });

        txtPercentIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissKeyboard();

            }
        });

        txtProfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissKeyboard();
            }
        });

        txtTotalProfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissKeyboard();
            }
        });
    }

    public void onClick(View v){
        dismissKeyboard();
    }

    private void dismissKeyboard(){
        edtOriginalPrice = findViewById(R.id.edtOriginalPrice);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtOriginalPrice.getWindowToken(),0);
    }

    private void calculateLogic(){
        edtOriginalPrice = findViewById(R.id.edtOriginalPrice);
        edtAmountBought = findViewById(R.id.edtAmountBought);
        edtSellingPrice = findViewById(R.id.edtSellingPrice);

        txtPercentIncrease = findViewById(R.id.txtPercentIncrease);
        txtProfit = findViewById(R.id.txtProfit);
        txtTotalProfit = findViewById(R.id.txtTotalProfit);

        Double originalPrice = Double.parseDouble(edtOriginalPrice.getText().toString());
        Double amountBought = Double.parseDouble(edtAmountBought.getText().toString());
        Double sellingPrice = Double.parseDouble(edtSellingPrice.getText().toString());

        Double profit =  (sellingPrice*amountBought) - (originalPrice * amountBought);

        Double percentIncrease = ((sellingPrice / originalPrice) - 1) * 100;

        Double totalProfit = sellingPrice * amountBought;

        String roundProfit = String.format("%1.2f", profit);
        String roundPercentIncrease = String.format("%1.0f", percentIncrease);
        String roundTotalProfit = String.format("%1.2f", totalProfit);

        txtPercentIncrease.setText(roundPercentIncrease+"%");
        txtProfit.setText("$"+ roundProfit);
        txtTotalProfit.setText("$"+ roundTotalProfit);
    }

    private void clearLogic(){

        edtOriginalPrice = findViewById(R.id.edtOriginalPrice);
        edtAmountBought = findViewById(R.id.edtAmountBought);
        edtSellingPrice = findViewById(R.id.edtSellingPrice);

        txtPercentIncrease = findViewById(R.id.txtPercentIncrease);
        txtProfit = findViewById(R.id.txtProfit);
        txtTotalProfit = findViewById(R.id.txtTotalProfit);

        edtOriginalPrice.setText("");
        edtAmountBought.setText("");
        edtSellingPrice.setText("");

        txtPercentIncrease.setText("Percent Increase");
        txtProfit.setText("Profit");
        txtTotalProfit.setText("Total Profit");
    }
}
