package umlgen;

import umlgen.status.Status;
import umlgen.visibilite.Public;
import umlgen.visibilite.Visibilite;

import java.util.ArrayList;

public class Attribut {

    private String nom;
    private Visibilite visi;
    private ArrayList<Status> status;
    private Object type;

    public Attribut(String pnom, Visibilite pvisi, ArrayList<Status> pstatus, Object pType) {
        this.nom = pnom;
        this.visi = pvisi;
        this.status = pstatus;
        this.type = pType;
    }

    public Attribut(String pnom, Object ptype) {
        this.nom = pnom;
        this.visi = new Public();
        this.status = new ArrayList<>();
        this.type = ptype;
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

    public Object getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Attribut{")
                .append("nom='").append(nom).append('\'')
                .append(", visi=").append(visi.getClass().getSimpleName())
                .append(", status=[");

        for (Status s : status) {
            sb.append(s.toString()).append(", ");
        }

        // Retirer la dernière virgule et espace si nécessaire
        if (!status.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("], type=").append(type instanceof Class ? ((Class<?>) type).getSimpleName() : type)
                .append('}');
        return sb.toString();
    }

}
