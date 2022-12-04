package Controller;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.io.*;

import Model.Entrepot;
import Model.Produit;

public class EntrepotController {

    public void ajouterEntrepot( String nomEntrepot, Context c){
        Context context = c;
        SharedPreferences sharedPreferencesEntrepot = context.getSharedPreferences("Entrepot",0);
        SharedPreferences.Editor editor = sharedPreferencesEntrepot.edit();

        int idProduit = sharedPreferencesEntrepot.getInt("idEntrepot",0)+1 ;
        editor.putInt("idEntrepot",idProduit);
        editor.putString("nomEntrepot",nomEntrepot);
        editor.commit();
//sharedPreferences a rajouter

    }

    public void modifierNomEntrepot(int id ,String nomModif,  Context c){
        Context context = c;
        SharedPreferences sharedPreferencesEntrepot = context.getSharedPreferences("Entrepot",0);
        SharedPreferences.Editor editor = sharedPreferencesEntrepot.edit();
        if (sharedPreferencesEntrepot.getInt("idEntrepot",0) == id){
            editor.putString("nomEntrepot",nomModif);
            editor.commit();
        }
    }

    public void supprimerEntrepot(int id, String nom, Context c){
        Context context = c;
        SharedPreferences sharedPreferencesEntrepot = context.getSharedPreferences("Entrepot",0);
        SharedPreferences.Editor editor = sharedPreferencesEntrepot.edit();
        if (sharedPreferencesEntrepot.getInt("idEntrepot",0) == id){
            editor.remove("idEntrepot").apply();
            editor.remove("nomEntrepot").apply();
            editor.commit();
        }


    }



}
