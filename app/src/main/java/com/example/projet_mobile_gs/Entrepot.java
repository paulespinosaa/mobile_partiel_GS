package com.example.projet_mobile_gs;

import java.util.ArrayList;

import io.realm.RealmObject;

public class Entrepot extends RealmObject {

    private String nomEntrepot;
    private int idEntrepot;

    public void setNomEntrepot(String nomEntrepot) {
        this.nomEntrepot = nomEntrepot;
    }

    public String getNomEntrepot() {
        return nomEntrepot;
    }

    public int getIdEntrepot() {
        return idEntrepot;
    }

    public void setIdEntrepot(int idEntrepot) {
        this.idEntrepot = idEntrepot;
    }
}