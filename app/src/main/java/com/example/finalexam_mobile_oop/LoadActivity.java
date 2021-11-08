package com.example.finalexam_mobile_oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import maes.tech.intentanim.CustomIntent;

public class LoadActivity extends AppCompatActivity {

    Button home;

    TextView finalTypeSelection;
    TextView finalColorSelection;
    TextView finalSizeSelection;

    ImageView finalImageSelection;

    String finalType = "";
    String finalColor = "";
    String finalSize = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        home = findViewById(R.id.homeButton);
        finalTypeSelection = findViewById(R.id.loadTypeView);
        finalColorSelection = findViewById(R.id.loadColorView);
        finalSizeSelection = findViewById(R.id.loadSizeView);
        finalImageSelection = findViewById(R.id.loadImageView);

        Intent intent4 = getIntent();
        finalType = intent4.getStringExtra("type2_key");
        finalColor = intent4.getStringExtra("color2_key");
        finalSize = intent4.getStringExtra("size2_key");

        finalTypeSelection.setText("Type  : " + finalType);
        finalColorSelection.setText("Color : "+ finalColor);
        finalSizeSelection.setText("Size   : " + finalSize);

        if(finalType.contains("Shirt") && finalColor.contains("Red"))
        {
            finalImageSelection.setImageResource(R.drawable.baju_merah);
        }
        else if(finalType.contains("Shirt") && finalColor.contains("Green"))
        {
            finalImageSelection.setImageResource(R.drawable.baju_hijau);
        }
        else if(finalType.contains("Shirt") && finalColor.contains("Blue"))
        {
            finalImageSelection.setImageResource(R.drawable.baju_biru);
        }
        else if(finalType.contains("Pants") && finalColor.contains("Red"))
        {
            finalImageSelection.setImageResource(R.drawable.celana_merah);
        }
        else if(finalType.contains("Pants") && finalColor.contains("Green"))
        {
            finalImageSelection.setImageResource(R.drawable.celana_hijau);
        }
        else if(finalType.contains("Pants") && finalColor.contains("Blue"))
        {
            finalImageSelection.setImageResource(R.drawable.celana_biru);
        }
        else if(finalType.contains("Hat") && finalColor.contains("Red"))
        {
            finalImageSelection.setImageResource(R.drawable.topi_merah);
        }
        else if(finalType.contains("Hat") && finalColor.contains("Green"))
        {
            finalImageSelection.setImageResource(R.drawable.topi_hijau);
        }
        else if(finalType.contains("Hat") && finalColor.contains("Blue"))
        {
            finalImageSelection.setImageResource(R.drawable.topi_biru);
        }

        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent backHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backHome);
                CustomIntent.customType(LoadActivity.this, "fadein-to-fadeout");
            }
        });
    }
}