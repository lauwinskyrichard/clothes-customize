package com.example.finalexam_mobile_oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;

public class SecondActivity extends AppCompatActivity {

    TextView typeSelection;
    TextView colorSelection;
    TextView sizeSelection;

    ImageView imageSelection;

    String pilihanTipe = "";
    String pilihanWarna = "";
    String pilihanSize = "";

    Button save;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        typeSelection = findViewById(R.id.typeView);
        colorSelection = findViewById(R.id.colorView);
        sizeSelection = findViewById(R.id.sizeView);
        imageSelection = findViewById(R.id.imageView);
        save = findViewById(R.id.saveButton);

        Intent intent = getIntent();
        pilihanTipe = intent.getStringExtra("type_key");
        pilihanWarna = intent.getStringExtra("color_key");
        pilihanSize = intent.getStringExtra("size_key");

        typeSelection.setText("Type  : " + pilihanTipe);
        colorSelection.setText("Color : "+ pilihanWarna);
        sizeSelection.setText("Size   : " + pilihanSize);

        if(pilihanTipe.contains("Shirt") && pilihanWarna.contains("Red"))
        {
            imageSelection.setImageResource(R.drawable.baju_merah);
        }
        else if(pilihanTipe.contains("Shirt") && pilihanWarna.contains("Green"))
        {
            imageSelection.setImageResource(R.drawable.baju_hijau);
        }
        else if(pilihanTipe.contains("Shirt") && pilihanWarna.contains("Blue"))
        {
            imageSelection.setImageResource(R.drawable.baju_biru);
        }
        else if(pilihanTipe.contains("Pants") && pilihanWarna.contains("Red"))
        {
            imageSelection.setImageResource(R.drawable.celana_merah);
        }
        else if(pilihanTipe.contains("Pants") && pilihanWarna.contains("Green"))
        {
            imageSelection.setImageResource(R.drawable.celana_hijau);
        }
        else if(pilihanTipe.contains("Pants") && pilihanWarna.contains("Blue"))
        {
            imageSelection.setImageResource(R.drawable.celana_biru);
        }
        else if(pilihanTipe.contains("Hat") && pilihanWarna.contains("Red"))
        {
            imageSelection.setImageResource(R.drawable.topi_merah);
        }
        else if(pilihanTipe.contains("Hat") && pilihanWarna.contains("Green"))
        {
            imageSelection.setImageResource(R.drawable.topi_hijau);
        }
        else if(pilihanTipe.contains("Hat") && pilihanWarna.contains("Blue"))
        {
            imageSelection.setImageResource(R.drawable.topi_biru);
        }

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("TYPE", pilihanTipe);
        editor.putString("COLOR", pilihanWarna);
        editor.putString("SIZE", pilihanSize);
        editor.apply();

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);

                Toast.makeText(getApplicationContext(), "Saved Successfully!", Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                CustomIntent.customType(SecondActivity.this, "up-to-bottom");
            }
        });


    }

}