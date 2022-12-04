package com.example.projet_mobile_gs;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import Controller.EntrepotController;

public class add_entrepot extends AppCompatActivity {


    private ImageButton arrowBack;
    private ImageButton buttonSave;
    private EditText textNomEntrepot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_entrepot);

        arrowBack = findViewById(R.id.arrowBack);
        buttonSave = (ImageButton) findViewById(R.id.boutonSave);
        textNomEntrepot = (EditText) findViewById(R.id.add_entrepot_nom);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntrepotController controller =  new EntrepotController();
                String nomEntrepot = textNomEntrepot.getText().toString();
                Context context = getApplicationContext();
                controller.ajouterEntrepot(nomEntrepot, context);
                Intent intent = getIntent();

            }
        });







    }
}
