package dz.univtemouchent.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class version_simple extends AppCompatActivity implements View.OnClickListener{
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;
    private String k;
    private String joueur_symbol;
    private String machine_symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_simple);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_HMA_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        qui_jeux_HMA();

    }
    public void qui_jeux_HMA(){ // function aliatoire pour défini qui jeux le premier ?
        int k=  (int) (0+Math.random()*((1-0)+1));
        if (k==0){
            machintour_HMA();
            player1Turn=!player1Turn;
        }
    }


    @Override
    public void onClick(View v) { // function tour de joueur
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) v).setText("X");
            verifier_HMA();
        }
        if (!player1Turn){
            machintour_HMA();}
    }
    public void machintour_HMA(){ // function tour de machine
        int i= (int) (Math.random()*3);
        int j= (int) (Math.random()*3);

        if (buttons[i][j].getText().toString().equals("")){
            buttons[i][j].setText("O");
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
    private boolean qui_gagne_HMA() { // function pour remplir deuxième tableaux et verifier si le joueur ou la machine gagne
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
        k ="Vous avez gagné!";
        resetPartie_HMA();
    }
    private void machineGagne_HMA() { // function pour affiche la machine gagne
        k ="Vous avez perdu!";
        resetPartie_HMA();
    }
    private void partie_nul_HMA() { // function pour affiche la partie null
        k ="Match null!";
        resetPartie_HMA();
    }

    private void resetPartie_HMA() { // function pour reset parie
        // SystemClock.sleep(6000);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        roundCount = 0;
        player1Turn = true;
        open_repons_HMA();
    }
    public void open_repons_HMA () { // function pour ouvrir l'interface repons
        String message = k;
        Intent intent=  new Intent(this, repons1.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }

}

