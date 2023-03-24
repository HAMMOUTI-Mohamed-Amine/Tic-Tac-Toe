package dz.univtemouchent.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class repons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repons);
        /*pour afficher les statistique*/
        // nbr de partie
        String intent = getIntent().getStringExtra("message");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("Nombre de partie : " + intent);
        // Nombre de matche gagne
         intent = getIntent().getStringExtra("message2");
        TextView tv2 = (TextView) findViewById(R.id.textView1);
        tv2.setText("Nombre de matche gagne : " + getIntent().getStringExtra("message2"));

        intent = getIntent().getStringExtra("message3");
        TextView tv3 = (TextView) findViewById(R.id.textView2);
        tv3.setText("Nombre de matche perd : " + getIntent().getStringExtra("message3"));
        // Nombre de matche perd
        intent = getIntent().getStringExtra("message4");
        TextView tv4 = (TextView) findViewById(R.id.textView3);
        tv4.setText("Nombre de matche null : " + getIntent().getStringExtra("message4"));
        //Nombre de matche null
    }

    public void exit_HMA(View view){ // function pour ouvrir l'interface MainActivity
        Intent intent=  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void rejouer (View view) { // function pour ouvrir l'interface Moriponlayout
        Intent intent=  new Intent(this, Moriponlayout.class);
        startActivity(intent);
    }
}
