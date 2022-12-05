package com.example.projet_mobile_gs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class list_produit extends AppCompatActivity {

    private ImageButton addButton;
    private ImageButton arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        arrowBack = findViewById(R.id.arrowBack);
        arrowBack.setVisibility(View.VISIBLE);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        int entrepotID = getIntent().getIntExtra("entrepotID", 0);

        addButton = findViewById(R.id.boutonAdd2);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), add_produit.class);
                intent.putExtra("entrepotID", entrepotID);
                startActivity(intent);
            }
        });


        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Produit> produitsList =  realm.where(Produit.class).equalTo("idEntrepot",entrepotID).findAll();

        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        MyAdapterProduit myAdapterProduit = new MyAdapterProduit(getApplicationContext(), produitsList);
        recyclerView2.setAdapter(myAdapterProduit);

        produitsList.addChangeListener(new RealmChangeListener<RealmResults<Produit>>() {
            @Override
            public void onChange(RealmResults<Produit> produits) {
                myAdapterProduit.notifyDataSetChanged();
            }
        });
    }



}