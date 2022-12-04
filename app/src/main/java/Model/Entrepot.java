package Model;

import java.util.ArrayList;

public class Entrepot {
    private int idEntrepot;
    private String nomEntrepot;
    private ArrayList<Produit> produits =  new ArrayList<>();

    public Entrepot(){}

    public Entrepot(int idEntrepot,String nomEntrepot, ArrayList<Produit> produits){
        this.nomEntrepot = nomEntrepot;
        this.produits = produits;
    }

    public int getIdEntrepot() {
        return idEntrepot;
    }

    public void setIdEntrepot(int idEntrepot) {
        this.idEntrepot = idEntrepot;
    }

    public void setNomEntrepot(String nomEntrepot) {
        this.nomEntrepot = nomEntrepot;
    }

    public String getNomEntrepot() {
        return nomEntrepot;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }
}
