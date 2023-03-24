package dz.univtemouchent.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class repons2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repons2);
        String intent = getIntent().getStringExtra("message");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText( intent);
    }
    public void exit_HMA(View view){ // function pour ouvrir l'interface MainActivity
        Intent intent=  new Intent(this, MainActivity.class);
        startActivity(intent);    }

    public void rejouer (View view) { // function pour ouvrir l'interface joueurs_2
        Intent intent=  new Intent(this, joueurs_2.class);
        startActivity(intent);
    }
}
