package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmicalculator.R;

public class MainActivity extends AppCompatActivity {
    private EditText weight;
    private EditText height;
    private EditText Name;
    private TextView resultTextView ;
    private TextView discription;
    String calculation, BMIresult  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resultTextView = findViewById(R.id.resultTextView);
        discription = findViewById(R.id.discription);
        Name = findViewById(R.id.Name);


        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightString = weight.getText().toString();
        String heightString = height.getText().toString();
        String NameString = Name.getText().toString();

        if (!weightString.isEmpty() && !heightString.isEmpty()) {
            float weight = Float.parseFloat(weightString);
            float height = Float.parseFloat(heightString)   / 100;


            float bmi = weight / ( height * height );




            if (bmi<16){
                BMIresult ="Severely under weight";
            }
            else if (bmi <18.5){
                BMIresult="under weight";
            }
            else if(bmi >=18.5 && bmi<=24.9){
                BMIresult="Normal weight";
            }
            else if(bmi >=25 && bmi<=29.9){
                BMIresult="Over weight";
            }
            calculation = "result:\n\n" +NameString + bmi + "\n" +BMIresult;
            resultTextView.setText( NameString + "your BMI is " + bmi);
            discription.setText( BMIresult );
        } else {
            Toast.makeText(this, "Please enter weight and height", Toast.LENGTH_SHORT).show();
        }


    }
}
