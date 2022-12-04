package Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.Entrepot;
import Model.Produit;

public class EntrepotController {

    public ArrayList<Entrepot> ajouterEntrepot(int idProduit, String nomEntrepot, ArrayList<Entrepot> entrepots){
        ArrayList<Entrepot> entrepotsList = entrepots;
        ArrayList<Produit> produits = new ArrayList<>();
        Entrepot entrepot =  new Entrepot(idProduit,nomEntrepot,produits);
        entrepotsList.add(entrepot);

//sharedPreferences a rajouter


        return  entrepotsList;
    }

    public void modifierNomEntrepot(String nom ,String nomModif, ArrayList<Entrepot> entrepots){
        ArrayList<Entrepot> entrepotsList = entrepots;
        Entrepot entrepot =  new Entrepot();
        for (int i=0 ; i< entrepotsList.size();i++){
            if (entrepotsList.get(i).equals(nom)){
                entrepotsList.get(i).setNomEntrepot(nomModif);
              // sharedPreferrences à modifier
            }
        }
    }

    public void supprimerEntrepot(String nom, ArrayList<Entrepot> entrepots){
        ArrayList<Entrepot> entrepotsList = entrepots;
        Entrepot entrepot =  new Entrepot();
        for (int i=0 ; i< entrepotsList.size();i++){
            if (entrepotsList.get(i).equals(nom)){
                entrepotsList.remove(i);
                // sharedPreferrences à supprimer des shared preferences
            }
        }
    }



}
