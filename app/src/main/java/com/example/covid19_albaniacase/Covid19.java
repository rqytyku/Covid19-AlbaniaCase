package com.example.covid19_albaniacase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class Covid19 extends AppCompatActivity {

    ImageView flamur; //inicializimi
    Spinner spinner;
    Button stat;
    ImageView kthehuRomela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid19);

        spinner = findViewById(R.id.spinner);
        flamur = findViewById(R.id.flag);
        stat = findViewById(R.id.stat);

        kthehuRomela = findViewById(R.id.imageView);

        kthehuRomela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(Covid19.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                ZonaData.countryNames));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                flamur.setImageResource(ZonaData.countryFlag[spinner.getSelectedItemPosition()]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
//Metoda qe do perdoret per te hapur ekranin i cili shfaq Statistikat, pasi klikon tek Shiko Statistikat
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( Covid19.this, Statistics.class);
                startActivity(i);
            }
        });
    }
}