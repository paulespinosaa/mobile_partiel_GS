package com.example.projet_mobile_gs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import io.realm.Realm;
import io.realm.RealmResults;

public class EditProduit extends AppCompatActivity {

    private ImageButton arrowBack;
    private EditText nomProduitInput;
    private EditText quantiteProduit;
    private ImageButton ajouterProduit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        int entrepotID = getIntent().getIntExtra("entrepotID", 0);
        String nomProduit = getIntent().getStringExtra("nomProduit");
        String quantiteProduitAncien = getIntent().getStringExtra("quantite");

        nomProduitInput = findViewById(R.id.nomProduitOut);
        quantiteProduit = findViewById(R.id.quantiteProduitOut);
        ajouterProduit = (ImageButton) findViewById(R.id.boutonSave2);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Produit> listProduit = realm.where(Produit.class).findAll();
        Produit newProduit = new Produit();

        for (Produit produit : listProduit) {
            if(produit.getNomProduit().equals(nomProduit)){
                newProduit = produit;
            }
        }

        nomProduitInput.setText(newProduit.getNomProduit());
        quantiteProduit.setText(newProduit.getQuantite() + "");

        Realm.init(getApplicationContext());

        arrowBack = findViewById(R.id.arrowBack);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Produit finalNewProduit = newProduit;
        ajouterProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomPdt = nomProduitInput.getText().toString();
                int qtte = Integer.valueOf( quantiteProduit.getText().toString());

                realm.beginTransaction();
                finalNewProduit.deleteFromRealm();
                Produit produit =  realm.createObject(Produit.class);
                produit.setNomProduit(nomPdt);
                produit.setQuantite(qtte);
                produit.setIdEntrepot(entrepotID);
                realm.commitTransaction();
                finish();
            }
        });


    }
}