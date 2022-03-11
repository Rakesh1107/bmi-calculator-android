package com.raki.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitBtn = findViewById(R.id.button);
        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView weightField = findViewById(R.id.weight);
        TextView heightField = findViewById(R.id.height);

        if (!weightField.getText().toString().equals("") && !heightField.getText().toString().equals("")) {
            TextView msg = findViewById(R.id.message);
            msg.setText("");
            double weight = Double.parseDouble(weightField.getText().toString());
            double height = Double.parseDouble(heightField.getText().toString());

            String bmi = calculateBMI(weight, height);

            TextView bmiField = findViewById(R.id.bmi);
            bmiField.setText(bmi);

            TextView verdictField = findViewById(R.id.verdict);

            if (Double.parseDouble(bmi) < 18.5) {
                verdictField.setText("You are underweight. You need to eat more");
            }
            else if (Double.parseDouble(bmi) > 25) {
                verdictField.setText("Oops! You are overweight");
            }
            else {
                verdictField.setText("Congrats! You are normal");
            }
        }
        else {
            TextView msg = findViewById(R.id.message);
            msg.setText("Enter weight anf height");
        }
    }

    private String calculateBMI(double weight, double height) {
        double bmi = weight / (height * height);
        String bmiValue = String.format("%.2f", bmi);
        return bmiValue;
    }
}