package com.example.projet_mobile_gs;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;

public class add_entrepot extends AppCompatActivity {


    private ImageButton arrowBack;
    private EditText nomEntrepotInput;
    private ImageButton ajouterEntrepot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_entrepot);

        nomEntrepotInput = findViewById(R.id.add_entrepot_nom);
        ajouterEntrepot = (ImageButton) findViewById(R.id.boutonSave);


        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();


        arrowBack = findViewById(R.id.arrowBack);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ajouterEntrepot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomEntrepot = nomEntrepotInput.getText().toString();
                realm.beginTransaction();
                Entrepot entrepot =  realm.createObject(Entrepot.class);
                entrepot.setNomEntrepot(nomEntrepot);
                realm.commitTransaction();
                finish();

            }
        });

    }
}
