package dz.univtemouchent.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Moriponlayout extends AppCompatActivity implements View.OnClickListener  {
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;
    private String k;
    private int joueur1Points;
    private int machinePoints;
    private int matchenullPoints;
    private TextView textViewjoueur1_HMA;
    private TextView textViewmachine_HMA;
    private TextView textViewmatch_null_HMA;
    private String joueur_symbol;
    private String machine_symbol;
    private int nbr_partie_HMA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moriponlayout);
        textViewjoueur1_HMA = findViewById(R.id.textView_HMA);
        textViewmatch_null_HMA = findViewById(R.id.textView3_HMA);
        textViewmachine_HMA = findViewById(R.id.textView2_HMA);


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_HMA_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        symbol_HMA();
        qui_jeux_HMA();


    }
    public void qui_jeux_HMA(){ // function aliatoire pour défini qui jeux le premier ?
        int k=  (int) (0+Math.random()*((1-0)+1));
        if (k==0){
            machintour_HMA();
            player1Turn=!player1Turn;
        }
    }
    public void symbol_HMA(){ // function aliatoire pour les symboles
        int s= (int) (0+Math.random()*((1-0)+1));
        if (s==0){
            machine_symbol="X";
            joueur_symbol="O";
        }else{
            machine_symbol="O";
            joueur_symbol="X";}
    }

    @Override
    public void onClick(View v) { // function tour de joueur
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) v).setText(joueur_symbol);
            verifier_HMA();
        }
        if (!player1Turn){
            machintour_HMA();}
    }
    public void machintour_HMA(){ // function tour de machine
        int i= (int) (Math.random()*3);
        int j= (int) (Math.random()*3);

        if (buttons[i][j].getText().toString().equals("")){
            buttons[i][j].setText(machine_symbol);
            verifier_HMA();
        }
        else {
            machintour_HMA();
        }
    }
    public void verifier_HMA(){
        roundCount++;
        if (qui_gagne_HMA()) {
            if (player1Turn) {
                joueur1Gagne_HMA();
            } else {
                machineGagne_HMA();
            }
        } else if (roundCount == 9) {
            partie_nul_HMA();
        } else {
            player1Turn = !player1Turn;
        }
    }
    private boolean qui_gagne_HMA() { // function pour remplir deuxième tableaux et  verifier si le joueur ou la machine gagne
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }
        return false;
    }
    private void joueur1Gagne_HMA() { // function pour affiche le joueur gagne
         joueur1Points++;
         k ="Vous avez gagné!";
        PointsText_HMA();
        resetPartie_HMA();
    }
    //machine wins
    private void machineGagne_HMA() { // function pour affiche la machine gagne
        machinePoints++;
         k ="Vous avez perdu!";
        PointsText_HMA();
        resetPartie_HMA();
    }
    private void partie_nul_HMA() { // function pour affiche la partie null
        matchenullPoints++;
         k ="Match null!";
        PointsText_HMA();
        resetPartie_HMA();
    }
    private void PointsText_HMA() { // function pour afficher les compteurs
        textViewjoueur1_HMA.setText("Joueur: " + joueur1Points);
        textViewmatch_null_HMA.setText("Null: " + matchenullPoints);
        textViewmachine_HMA.setText("Machine: " + machinePoints);

    }
    private void resetPartie_HMA() { // function pour reset parie
        nbr_partie_HMA++;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        roundCount = 0;
        player1Turn = true;
        symbol_HMA();
        qui_jeux_HMA();
    }


    public void open_repons_HMA (View view ) { // function pour ouvrir l'interface repons
        Intent intent=  new Intent(this, repons.class);
       // String message = String.valueOf(nbr_partie_HMA);;
        intent.putExtra("message", String.valueOf(nbr_partie_HMA));
        intent.putExtra("message2", String.valueOf(joueur1Points));
        intent.putExtra("message3", String.valueOf(machinePoints));
        intent.putExtra("message4", String.valueOf(matchenullPoints));
        startActivity(intent);
    }


    public void reset_compteur_HMA(View view) { // function pour reset les compteur
        nbr_partie_HMA=0;
        resetPartie_HMA();
        textViewjoueur1_HMA.setText("Joueur:");
        textViewmachine_HMA.setText("Machine:");
        textViewmatch_null_HMA.setText("Null:");
        joueur1Points=0;
        machinePoints=0;
        matchenullPoints=0;
    }
}
