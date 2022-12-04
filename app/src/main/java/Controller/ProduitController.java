package Controller;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

import Model.Entrepot;
import Model.Produit;

public class ProduitController {

    public void ajouterProduit( int idEntrepot , String nomProduit, int quantite, String image, String references, Context c){
        Context context = c;
        SharedPreferences sharedPreferencesProduit = context.getSharedPreferences("Produit",0);
        SharedPreferences.Editor editor = sharedPreferencesProduit.edit();

        int idProduit = sharedPreferencesProduit.getInt("idProduit",0)+1 ;
        editor.putInt("idProduit",idProduit);
        editor.putString("nomProduit",nomProduit);
        editor.putInt("quantite",quantite);
        editor.putString("image",image);
        editor.putString("references",references);
        editor.putInt("idEntrepot",idEntrepot);
        editor.commit();
    }

    public void modifierProduit(int id , String nomModif,int newQuantite, String newImage, String newReference, Context c) {
        Context context = c;
        SharedPreferences sharedPreferencesProduit = context.getSharedPreferences("Produit",0);
        SharedPreferences.Editor editor = sharedPreferencesProduit.edit();
        if (sharedPreferencesProduit.getInt("idEntrepot",0) == id){
            editor.putString("nomProduit",nomModif);
            editor.putInt("quantite",newQuantite);
            editor.putString("image",newImage);
            editor.putString("references",newReference);
            editor.commit();
        }
    }

        public void supprimerProduit (int id, Context c){
            Context context = c;
            SharedPreferences sharedPreferencesProduit = context.getSharedPreferences("Entrepot",0);
            SharedPreferences.Editor editor = sharedPreferencesProduit.edit();
            if (sharedPreferencesProduit.getInt("idEntrepot",0) == id){
                editor.remove("idProduit").apply();
                editor.remove("nomProduit").apply();
                editor.remove("quantite").apply();
                editor.remove("image").apply();
                editor.remove("references").apply();
                editor.remove("idEntrepot").apply();
                editor.commit();
            }
        }
    }