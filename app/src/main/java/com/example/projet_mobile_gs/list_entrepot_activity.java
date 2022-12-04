package com.example.projet_mobile_gs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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

    }
}