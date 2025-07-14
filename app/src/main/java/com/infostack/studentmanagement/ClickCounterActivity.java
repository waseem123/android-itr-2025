package com.infostack.studentmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ClickCounterActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_plus,btn_minus;
    TextView tv_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_click_counter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_count = findViewById(R.id.tv_count);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus=findViewById(R.id.btn_plus);

        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_plus) {
            int count = Integer.parseInt(tv_count.getText().toString());
            count++;
            tv_count.setText(count + "");
        }else if(v.getId()==R.id.btn_minus){
            int count = Integer.parseInt(tv_count.getText().toString());
            count--;
            tv_count.setText(count + "");
        }
    }
}