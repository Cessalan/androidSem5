package com.example.carwash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    //create variables
    private EditText washNumber;
    private RadioGroup prices;
    private Button calculate_btn;
    private TextView showPrice_tv;
    private Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiate variables
        washNumber=findViewById(R.id.washNumber);
        prices=findViewById(R.id.exteriorChoiceGroup);
        calculate_btn=findViewById(R.id.calculate_btn);
        showPrice_tv=findViewById(R.id.finalPrice_tv);
        service=new Service();
        registerListener();

        //display price when button is clicked
        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              displayPrice();

            }
        });

    }
    //determine price
    private void registerListener(){
        prices.setOnCheckedChangeListener(priceListener);
    }
    private RadioGroup.OnCheckedChangeListener priceListener= new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int RadioID) {
            switch (RadioID){
                case R.id.exterior5bucks:
                  //  Log.d("fatsy", "onCheckedChanged: 5 BUCKS");
                    service.setService(5);
                    break;

                case R.id.exterior10bucks:
                   // Log.d("fatsy", "onCheckedChanged: 10 BUCKS");
                    service.setService(10);
                    break;

            }

        }
    };
    //displays formatted price
    private void displayPrice(){
        NumberFormat numberFormat= NumberFormat.getCurrencyInstance();
        int number=Integer.parseInt(washNumber.getText().toString());
         double finalPrice=service.getTotalPrice(number);
          showPrice_tv.setText(String.valueOf(numberFormat.format(finalPrice)));

    }


}
