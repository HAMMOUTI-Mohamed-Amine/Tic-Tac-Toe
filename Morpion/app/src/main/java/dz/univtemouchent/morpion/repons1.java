package dz.univtemouchent.morpion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class repons1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repons1);
        String intent = getIntent().getStringExtra("message");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText( intent);
    }
    public void exit_HMA(View view){ // function pour ouvrir l'interface MainActivity
        Intent intent=  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void rejouer (View view) { // function pour ouvrir l'interface version_simple
        Intent intent=  new Intent(this, version_simple.class);
        startActivity(intent);
    }
}
