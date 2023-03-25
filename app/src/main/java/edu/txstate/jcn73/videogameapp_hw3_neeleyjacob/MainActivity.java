package edu.txstate.jcn73.videogameapp_hw3_neeleyjacob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewGames = findViewById(R.id.btnNext);

        viewGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainActivity.this, thing.class);
                startActivity(next);
            }
        });
    }
}