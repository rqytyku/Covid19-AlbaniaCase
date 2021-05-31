package com.example.covid19_albaniacase;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
//deklarimi i variableve
    Button b1,b2;
    EditText ed1,ed2;
    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //kalimi i vendodhjes se widgets tek variablave te mesiperme
        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vendosim kodin tone qe do ekzekutohet kur klikohet butoni login
                if(ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("password")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    // therritja e metodes te deklaruar me poshte, e cila kalon ne ekranin pasardhes
                    hapEkranin2Romela();

                }else{
                    //Toast qe sherben per daljen e "pop up ose modal" me mesazhin e meposhtem
                    Toast.makeText(getApplicationContext(), "Keni futur username dhe/ose passwordin gabim",Toast.LENGTH_SHORT).show();

                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
// metode e cila do te sherbej per tu loguar dhe kaluar ne ekranin tjeter, perkatesisht Ekrani2
    private void hapEkranin2Romela() {
        Intent i = new Intent(MainActivity.this, Ekrani2.class);
        String user = ed1.getText().toString();
        String password = ed2.getText().toString();
        i.putExtra("Username", user);
        i.putExtra("Password", password);
        i.putExtra("Keshilla:", "Stay Safe!");
        startActivity(i);
    }
}

