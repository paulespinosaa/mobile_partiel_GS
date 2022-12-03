package Model;

public class Produit {
    private String nomProduit;
    private int quantite;
    private String image;
    private String references;

    public Produit(){}

    public Produit(String nomProduit, int quantite, String image, String references){
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }
}
