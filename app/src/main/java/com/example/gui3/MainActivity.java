package com.example.gui3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextHeight, editTextWeight;
    private Button buttonCalculateBMI;
    private TextView textViewBMIResult, textViewDiagnosis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        textViewBMIResult = findViewById(R.id.textViewBMIResult);
        textViewDiagnosis = findViewById(R.id.textViewDiagnosis);

        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String heightStr = editTextHeight.getText().toString();
                String weightStr = editTextWeight.getText().toString();
                if (name.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }
                float height = Float.parseFloat(heightStr) / 100;
                float weight = Float.parseFloat(weightStr);

                float bmi = weight / (height * height);

                textViewBMIResult.setText(String.format("%.2f", bmi));

                String diagnosis;
                if (bmi < 18.5) {
                    diagnosis = "Gầy";
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    diagnosis = "Bình thường";
                } else if (bmi >= 25 && bmi < 29.9) {
                    diagnosis = "Thừa cân";
                } else {
                    diagnosis = "Béo phì";
                }

                textViewDiagnosis.setText(diagnosis);
            }
        });
    }
}