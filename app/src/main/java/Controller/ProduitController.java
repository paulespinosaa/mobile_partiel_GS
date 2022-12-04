package Controller;

import java.util.ArrayList;

import Model.Entrepot;
import Model.Produit;

public class ProduitController {

    public Produit ajouterProduit(ArrayList<Entrepot> entrepots, int idEntrepot ,int idProduit, String nomProduit, int quantite, String image, String references){
        Produit produit = new Produit(idProduit,nomProduit,quantite,image,references);
        ArrayList<Entrepot> entrepotsListe = entrepots;
        for(int i= 0 ; i < entrepotsListe.size(); i++){
            if (entrepotsListe.get(i).equals(idEntrepot)){
                entrepotsListe.get(i).getProduits().add(produit);
            }
        }



        //shared preferences
        return produit;
    }

    public void modifierProduit(String idProduit,ArrayList<Produit> produits, String newNom,int newQuantite, String newImage, String newReference ) {
        ArrayList<Produit> produitsListe = produits;
        for (int i = 0; i < produitsListe.size(); i++) {
            if (produitsListe.get(i).equals(idProduit)) {
                produitsListe.get(i).setNomProduit(newNom);
                produitsListe.get(i).setQuantite(newQuantite);
                produitsListe.get(i).setImage(newImage);
                produitsListe.get(i).setReferences(newReference);
                // sharedPreferrences à supprimer des shared preferences
            }
        }
    }

        public void supprimerProduit (String idProduit, ArrayList < Produit > produits){
            ArrayList<Produit> produitsListe = produits;
            for (int i = 0; i < produitsListe.size(); i++) {
                if (produitsListe.get(i).equals(idProduit)) {
                    produitsListe.remove(i);
                    // sharedPreferrences à supprimer des shared preferences
                }
            }

        }
    }