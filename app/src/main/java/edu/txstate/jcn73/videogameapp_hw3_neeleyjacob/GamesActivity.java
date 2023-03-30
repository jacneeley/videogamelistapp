package edu.txstate.jcn73.videogameapp_hw3_neeleyjacob;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GamesActivity extends ListActivity {
    ArrayList<Games> gamesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gamesList = new ArrayList<Games>();

        //list of data object
        Games g1 = new Games();
        g1.setId(1001);
        g1.setName("Doom");
        g1.setPrice(4.99);
        g1.setRating1(0);
        g1.setRating2(0);
        g1.setRating3(0);
        g1.setRating4(2500);
        g1.setRating5(3595);
        g1.setUrl("https://store.steampowered.com/app/2300/DOOM_II/");
        gamesList.add(g1);

        Games g2 = new Games();
        g2.setId(1002);
        g2.setName("Quake");
        g2.setPrice(9.99);
        g2.setRating1(1);
        g2.setRating2(0);
        g2.setRating3(2500);
        g2.setRating4(3897);
        g2.setRating5(3500);
        g2.setUrl("https://store.steampowered.com/app/2310/Quake/");
        gamesList.add(g2);

        Games g3 = new Games();
        g3.setId(1003);
        g3.setName("System Shock 2");
        g3.setPrice(9.99);
        g3.setRating1(1);
        g3.setRating2(34);
        g3.setRating3(2150);
        g3.setRating4(2000);
        g3.setRating5(1500);
        g3.setUrl("https://store.steampowered.com/app/238210/System_Shock_2/");
        gamesList.add(g3);

        Games g4 = new Games();
        g4.setId(1004);
        g4.setName("UltraKill");
        g4.setPrice(24.99);
        g4.setRating1(15);
        g4.setRating2(301);
        g4.setRating3(2579);
        g4.setRating4(45156);
        g4.setRating5(5167);
        g4.setUrl("https://store.steampowered.com/app/1229490/ULTRAKILL/");
        gamesList.add(g4);

        Games g5 = new Games();
        g5.setId(1001);
        g5.setName("Cultic");
        g5.setPrice(9.99);
        g5.setRating1(1);
        g5.setRating2(4);
        g5.setRating3(870);
        g5.setRating4(2001);
        g5.setRating5(1505);
        g5.setUrl("https://store.steampowered.com/app/1684930/CULTIC/");
        gamesList.add(g5);

        //CVM
        setListAdapter(new ArrayAdapter<Games>(
                GamesActivity.this,
                R.layout.game_item,
                R.id.txtGameBasic,
                gamesList
        ));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Games selectedGame = gamesList.get(position);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(GamesActivity.this);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("KEY_ID",selectedGame.getId());
        editor.putString("KEY_NAME", selectedGame.getName());
        editor.putFloat("KEY_PRICE", (float) selectedGame.getPrice());
        editor.putInt("KEY_R1", selectedGame.getRating1());
        editor.putInt("KEY_R2", selectedGame.getRating2());
        editor.putInt("KEY_R3", selectedGame.getRating3());
        editor.putInt("KEY_R4", selectedGame.getRating4());
        editor.putInt("KEY_R5", selectedGame.getRating5());
        editor.putString("KEY_URL",selectedGame.getUrl());
        editor.commit();

        Intent next = new Intent(GamesActivity.this, SelectedGame.class);
        startActivity(next);
    }
}