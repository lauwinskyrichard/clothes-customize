package com.example.finalexam_mobile_oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import maes.tech.intentanim.CustomIntent;

/*
    Richard Lauwinsky
    2301865842
    LA-03
*/

public class MainActivity extends AppCompatActivity {

    String selectedType = "";
    String selectedColor = "";
    String selectedSize = "";

    String[] type = {"Pick a Type", "Shirt", "Pants", "Hat"};
    String[] color = {"Pick a Color", "Red", "Green", "Blue"};
    String[] size = {"Pick a Size", "S", "M", "L", "XL"};

    List<String> typeList = new ArrayList<>(Arrays.asList(type));
    List<String> colorList = new ArrayList<>(Arrays.asList(color));
    List<String> sizeList = new ArrayList<>(Arrays.asList(size));

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;

    Integer typeListPosition = 0;
    Integer colorListPosition = 0;
    Integer sizeListPosition = 0;

    Button load;

    SharedPreferences saving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.typeSpinner);
        spinner2 = findViewById(R.id.colorSpinner);
        spinner3 = findViewById(R.id.sizeSpinner);

        load = findViewById(R.id.loadButton);

        //Untuk Type Selection
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, typeList)
        {
            @Override
            public boolean isEnabled(int position)
            {
                if(position==0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;

                if(position==0)
                {
                    tv.setTextColor(Color.GRAY);
                }
                else
                {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter1.setDropDownViewResource(R.layout.spinner_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(position==0)
                {
                    typeListPosition = 0;
                }
                else
                {
                    selectedType = (String) parent.getItemAtPosition(position);
                    typeListPosition = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Untuk Color Selection
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item, colorList)
        {
            @Override
            public boolean isEnabled(int position)
            {
                if(position==0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;

                if(position==0)
                {
                    tv.setTextColor(Color.GRAY);
                }
                else
                {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter2.setDropDownViewResource(R.layout.spinner_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(position==0)
                {
                    colorListPosition = 0;
                }
                else
                {
                    selectedColor = (String) parent.getItemAtPosition(position);
                    colorListPosition = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Untuk Size Selection
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.spinner_item, sizeList)
        {
            @Override
            public boolean isEnabled(int position)
            {
                if(position==0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;

                if(position==0)
                {
                    tv.setTextColor(Color.GRAY);
                }
                else
                {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter3.setDropDownViewResource(R.layout.spinner_item);
        spinner3.setAdapter(adapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(position==0)
                {
                    sizeListPosition = 0;
                }
                else
                {
                    selectedSize = (String) parent.getItemAtPosition(position);
                    sizeListPosition = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        load.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saving = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

                String getType = saving.getString("TYPE", "");
                String getColor = saving.getString("COLOR", "");
                String getSize = saving.getString("SIZE", "");
                Integer count = saving.getInt("COUNT", 0);

                if(getType.equals(""))
                {
                   Toast.makeText(getApplicationContext(), "Haven't Save Anything", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent3 = new Intent(getApplicationContext(), LoadActivity.class);
                    intent3.putExtra("type2_key", getType);
                    intent3.putExtra("color2_key", getColor);
                    intent3.putExtra("size2_key", getSize);
                    startActivity(intent3);
                    CustomIntent.customType(MainActivity.this, "right-to-left");
                }
            }
        });
    }

    public void clear()
    {
        saving = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = saving.edit();
        editor.clear();
        editor.commit();
    }

    //Tombol View
    public void preview(View v)
    {
        Intent intent = new Intent(this, SecondActivity.class);

        if(typeListPosition==0 && colorListPosition==0 && sizeListPosition==0)
        {
            Toast.makeText(this, "Haven't Choose Type, Color, & Size", Toast.LENGTH_SHORT).show();
        }
        else if(typeListPosition==1 && colorListPosition==0 && sizeListPosition==0)
        {
            Toast.makeText(this, "Haven't Choose Color & Size", Toast.LENGTH_SHORT).show();
        }
        else if(typeListPosition==0 && colorListPosition==1 && sizeListPosition==0)
        {
            Toast.makeText(this, "Haven't Choose Type & Size", Toast.LENGTH_SHORT).show();
        }
        else if(typeListPosition==0 && colorListPosition==0 && sizeListPosition==1)
        {
            Toast.makeText(this, "Haven't Choose Type & Color", Toast.LENGTH_SHORT).show();
        }
        else if(typeListPosition==1 && colorListPosition==1 && sizeListPosition==0)
        {
            Toast.makeText(this, "Haven't Choose Size", Toast.LENGTH_SHORT).show();
        }
        else if(typeListPosition==0 && colorListPosition==1 && sizeListPosition==1)
        {
            Toast.makeText(this, "Haven't Choose Type", Toast.LENGTH_SHORT).show();
        }
        else if(typeListPosition==1 && colorListPosition==0 && sizeListPosition==1)
        {
            Toast.makeText(this, "Haven't Choose Color", Toast.LENGTH_SHORT).show();
        }
        else
        {
            intent.putExtra("type_key", selectedType);
            intent.putExtra("color_key", selectedColor);
            intent.putExtra("size_key", selectedSize);
            startActivity(intent);
            CustomIntent.customType(this, "left-to-right");
        }
    }

    public void reset(View view)
    {
        clear();
        Toast.makeText(this, "Resetting...", Toast.LENGTH_SHORT).show();
    }
}

