package com.infostack.studentmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpinnerActivity extends AppCompatActivity {
    Spinner sp_city;
    TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sp_city = findViewById(R.id.sp_city);
        tv_message = findViewById(R.id.tv_message);
        String[] cityNames = {
                "Solapur",
                "Pune",
                "Mumbai",
                "Bengaluru",
                "Hyderabad",
                "Delhi",
                "Haryana",
                "Chandigarh"
        };
        SpinnerAdapter sp = new ArrayAdapter<String>(SpinnerActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cityNames);
        sp_city.setAdapter(sp);
        sp_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String city = cityNames[position];
                tv_message.setText("I live in " + city);
//                Toast.makeText(SpinnerActivity.this, cityNames[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SpinnerActivity.this, "SELECTED NOTHING", Toast.LENGTH_LONG).show();

            }
        });
    }
}