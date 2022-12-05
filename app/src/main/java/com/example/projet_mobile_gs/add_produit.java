package com.example.projet_mobile_gs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class add_produit extends AppCompatActivity {

    private ImageButton arrowBack;
    private EditText nomProduitIn;
    private EditText quantiteProduitIn;
    private ImageButton ajouterProduit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        arrowBack = findViewById(R.id.arrowBack);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        nomProduitIn = findViewById(R.id.nomProduitOut);
        quantiteProduitIn = findViewById(R.id.quantiteProduitOut);
        ajouterProduit = findViewById(R.id.boutonSave2);

        int entrepotID = getIntent().getIntExtra("entrepotID", 0);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        ajouterProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomProduit = nomProduitIn.getText().toString();
                int quantite = Integer.valueOf(quantiteProduitIn.getText().toString());
                realm.beginTransaction();
                Produit produit =  realm.createObject(Produit.class);
                produit.setNomProduit(nomProduit);
                produit.setQuantite(quantite);
                produit.setIdEntrepot(entrepotID);
                RealmResults<Produit> produits = realm.where(Produit.class).findAll();
                realm.commitTransaction();
                finish();

            }
        });

    }
}