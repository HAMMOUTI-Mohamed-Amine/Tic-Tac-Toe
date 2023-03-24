package dz.univtemouchent.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Partie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);
    }
    public void open_simple_HMA (View view) { // function pour ouvrir l'interface version simple
        Intent intent=  new Intent(this, version_simple.class);
        startActivity(intent);
    }
    public void open_avanse_HMA (View view) { // function pour  ouvrir l'interface Morpionlayout
        Intent intent=  new Intent(this, Moriponlayout.class);
        startActivity(intent);
    }
    public void open_2joueurs_HMA (View view) { // function pour ouvrir l'interface joueur_2
        Intent intent=  new Intent(this, joueurs_2.class);
        startActivity(intent);
    }
}
