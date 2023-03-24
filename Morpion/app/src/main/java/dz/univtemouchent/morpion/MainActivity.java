package dz.univtemouchent.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open_HMA (View view) { // function pour ouvrir l'interface partie
        Intent intent=  new Intent(this, Partie.class);
        startActivity(intent);
    }
    public void open_aide_HMA (View view) { // function pour ouvrir l'interface partie
        Intent intent=  new Intent(this, aide.class);
        startActivity(intent);
    }
    public void exit_HMA(View view){
        System.exit(0);
    }

}
