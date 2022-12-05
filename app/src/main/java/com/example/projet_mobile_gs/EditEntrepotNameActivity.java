package com.example.projet_mobile_gs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import io.realm.Realm;
import io.realm.RealmResults;

public class EditEntrepotNameActivity extends AppCompatActivity {

    private ImageButton arrowBack;
    private EditText nomEntrepotInput;
    private ImageButton ajouterEntrepot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_entrepot);
        int entrepotID = getIntent().getIntExtra("entrepotID", 0);
        nomEntrepotInput = findViewById(R.id.add_entrepot_nom);
        ajouterEntrepot = (ImageButton) findViewById(R.id.boutonSave);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Entrepot> listEntrepot = realm.where(Entrepot.class).findAll();
        Entrepot newEntrepot = new Entrepot();

        for (Entrepot entrepot : listEntrepot) {
            if(entrepot.getIdEntrepot() == entrepotID){
                newEntrepot = entrepot;
            }
        }

        nomEntrepotInput.setText(newEntrepot.getNomEntrepot());

        Realm.init(getApplicationContext());

        arrowBack = findViewById(R.id.arrowBack);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Entrepot finalNewEntrepot = newEntrepot;
        ajouterEntrepot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomEntrepot = nomEntrepotInput.getText().toString();
                realm.beginTransaction();
                finalNewEntrepot.deleteFromRealm();
                Entrepot entrepot =  realm.createObject(Entrepot.class);
                entrepot.setNomEntrepot(nomEntrepot);
                entrepot.setIdEntrepot(entrepotID);
                realm.commitTransaction();
                finish();
            }
        });

    }
}