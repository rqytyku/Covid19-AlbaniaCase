package com.example.covid19_albaniacase;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class Ekrani2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekrani2);
        Button kthehu = (Button) findViewById(R.id.button3);
        Button CovidRom = (Button) findViewById(R.id.button4);
        Button bInterneti = (Button) findViewById(R.id.button6);
        TextView prsh = (TextView) findViewById(R.id.textView5);
        prsh.setText("");

        //menaxhimi i te dhenave qe na vijne nga ekrani 1... i paperfunduar
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        // get data via the key
        String emri = extras.getString("Username");
        String pass = extras.getString("Password");
        String str3 = extras.getString("Keshilla:");

        if (emri != null) {
            // do something with the data

            //Toast.makeText(getApplicationContext(), emri , Toast.LENGTH_SHORT).show();
            Toast shfaqEmrin = Toast.makeText(this, " Pershendetje " + emri , LENGTH_SHORT);
            shfaqEmrin.setGravity(Gravity.CENTER,0,-300);
            shfaqEmrin.show();
            prsh.setText("Pershendetje z. /znj. : " + emri +"\nPasswordi juaj eshte: " + pass + "\n Keshilla:" +str3);

        }

        kthehu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //therrasim metoden qe do ekzekutohet me klikimin e butonit... shkojme tek ekrani 1
                hapEkranin1();
            }
        });
       //ketu fo therritet metoda RomelaCovid qe do sherbeje per te hapur ekranin Covid19
        CovidRom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        RomelaCovid19();
                ;
            }
        });
        bInterneti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ishp.gov.al/covid-19-ne-shqiperi/"));
                if(isIntentAvailable(getApplicationContext(), i)){
                    Toast.makeText(getApplicationContext(), "Ka program qe hap internetin" , Toast.LENGTH_SHORT).show();
                    startActivity(i);

                }else{

                    Toast.makeText(getApplicationContext(), "Nuk ka program" , Toast.LENGTH_SHORT).show();
                }


            }
        });
        //intent implicit


        GameOver();

    }
    public static boolean isIntentAvailable(Context ctx, Intent intent) {
        final PackageManager mgr = ctx.getPackageManager();
        List<ResolveInfo> list =
                mgr.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    //intent explicit
    private void hapEkranin1() {
        Intent i = new Intent(Ekrani2.this, MainActivity.class);
        startActivity(i);
    }
    private void RomelaCovid19() {
        Intent i = new Intent(Ekrani2.this, Covid19.class);
        startActivity(i);
    }

    private void GameOver() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("A doni te vazhdoni ne ekranin 2?")
                .setCancelable(false)
                .setPositiveButton("Vazhdo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Ju sapo kaluat ne ekranin 2" , Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Dil", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.show();
    }

}
