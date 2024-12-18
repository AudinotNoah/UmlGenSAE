package umlgen;

import umlgen.status.Status;
import umlgen.visibilite.Public;
import umlgen.visibilite.Visibilite;

import java.util.ArrayList;

public class Methode {

    private String nom;
    private Visibilite visi;
    private ArrayList<Status> status;
    private Object typeRetour;
    private ArrayList<Attribut> parametres;

    public Methode(String pnom, Visibilite pvisi, ArrayList<Status> pstatus, Object pTypeRetour, ArrayList<Attribut> pParametres) {
        this.nom = pnom;
        this.visi = pvisi;
        this.status = pstatus;
        this.typeRetour = pTypeRetour;
        this.parametres = pParametres;
    }

    public Methode(String pnom) {
        this.nom = pnom;
        this.visi = new Public();
        this.status = new ArrayList<>();
        this.typeRetour = null; // null = void
        this.parametres = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public Visibilite getVisi() {
        return visi;
    }

    public ArrayList<Status> getStatus() {
        return status;
    }

    public Object getTypeRetour() {
        return typeRetour;
    }

    public ArrayList<Attribut> getParametres() {
        return parametres;
    }
}
