package com.example.covid19_albaniacase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Statistics extends AppCompatActivity {

    //deklarimi i varibales back te "tipit" ImageView (widget)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //tregimi i vendodhjes se widget qe do kaloje ne variablen back
        back = findViewById(R.id.imageView);

        //metoda qe do veproje ne momentin qe do klikohet imazhi me variabel BACK
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intenti qe do sherbeje per kalimin ne ekranin pasardhes, perkatesisht Covid19
                Intent i =new Intent(Statistics.this, Covid19.class);
                startActivity(i);
                finish();

            }
        });
    }

}
