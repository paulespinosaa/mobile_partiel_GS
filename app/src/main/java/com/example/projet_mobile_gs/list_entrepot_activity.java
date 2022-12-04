package com.example.projet_mobile_gs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class list_entrepot_activity extends AppCompatActivity {

    private ImageButton addButton;
    private ImageButton arrowBack;
    private ListView listeAffichage;

    private static ArrayAdapter arrayAdapter;
    private static ArrayList<String> entrepots = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_entrepot);

        listeAffichage = (ListView) findViewById(R.id.listView);
        SharedPreferences sharedPreferencesEntrepot = getApplication().getSharedPreferences("Entrepot",0);
        HashSet<String> nomEntrepot = (HashSet<String>) sharedPreferencesEntrepot.getStringSet("nomEntrepot", null);
        if (nomEntrepot != null){
            entrepots = new ArrayList<>(nomEntrepot);
        }

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, entrepots);

        listeAffichage.setAdapter((ArrayAdapter) arrayAdapter);


        arrowBack = findViewById(R.id.arrowBack);
        arrowBack.setVisibility(View.INVISIBLE);

        // Prise en compte du bouton et lancement de l'intent add_entrepot
        addButton = findViewById(R.id.boutonAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), add_entrepot.class);
                startActivity(intent);
            }
        });





    }
}