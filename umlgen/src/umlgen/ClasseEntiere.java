package umlgen;

import umlgen.status.Status;
import umlgen.type.Classe;
import umlgen.type.Type;
import umlgen.visibilite.Public;
import umlgen.visibilite.Visibilite;

import java.util.ArrayList;

public class ClasseEntiere {

    private String nom;
    private Visibilite visi;
    private Type typeClasse;
    private ArrayList<Methode> methodes;
    private ArrayList<Attribut> attributs;
    private ArrayList<Status> status;

    public ClasseEntiere(String pnom, Visibilite pvisi, Type ptypeClasse, ArrayList<Methode> pmethodes, ArrayList<Attribut> pattributs,ArrayList<Status> pstatus) {
        this.nom = pnom;
        this.visi = pvisi;
        this.typeClasse = ptypeClasse;
        this.methodes = pmethodes;
        this.attributs = pattributs;
        this.status = pstatus;
    }

    public ClasseEntiere(String pnom) {
        this.nom = pnom;
        this.visi = new Public(); // Valeur par défaut pour Visibilite
        this.typeClasse = new Classe();
        this.methodes = new ArrayList<>();
        this.attributs = new ArrayList<>();
        this.status = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public Visibilite getVisi() {
        return visi;
    }

    public Type getTypeClasse() {
        return typeClasse;
    }

    public ArrayList<Methode> getMethodes() {
        return methodes;
    }

    public ArrayList<Attribut> getAttributs() {
        return attributs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClasseEntiere{")
                .append("nom='").append(nom).append('\'')
                .append(", visi=").append(visi.getClass().getSimpleName())
                .append(", typeClasse=").append(typeClasse.getClass().getSimpleName())
                .append(", status=[");

        for (Status s : status) {
            sb.append(s.toString()).append(", ");
        }

        // Retirer la dernière virgule et espace si nécessaire
        if (!status.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("], attributs=[");

        for (Attribut attr : attributs) {
            sb.append(attr.toString()).append(", ");
        }

        if (!attributs.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("], methodes=[");

        for (Methode method : methodes) {
            sb.append(method.toString()).append(", ");
        }

        if (!methodes.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("]}");
        return sb.toString();
    }

}
