package com.example.projet_mobile_gs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class list_entrepot_activity extends AppCompatActivity {

    private ImageButton addButton;
    private ImageButton arrowBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_entrepot);

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


        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Entrepot> entrepotsList =  realm.where(Entrepot.class).findAll();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), entrepotsList);
        recyclerView.setAdapter(myAdapter);

        entrepotsList.addChangeListener(new RealmChangeListener<RealmResults<Entrepot>>() {
            @Override
            public void onChange(RealmResults<Entrepot> entrepots) {
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}