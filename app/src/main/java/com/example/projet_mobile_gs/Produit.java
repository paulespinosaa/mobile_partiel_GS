package com.example.projet_mobile_gs;


public class Produit {

    private String nomProduit;
    private int quantite;
    private String references;

 

    public Produit(String nomProduit, int quantite, String references){

        this.nomProduit = nomProduit;
        this.quantite = quantite;

        this.references = references;
    }



    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }



    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }
}