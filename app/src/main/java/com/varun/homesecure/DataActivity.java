package com.varun.homesecure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    private Button data;
    private Button image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        image = findViewById(R.id.imgBtn);
        data = findViewById(R.id.dataBtn);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataActivity.this,ImageView.class);
                startActivity(intent);
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}