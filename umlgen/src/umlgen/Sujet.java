package umlgen;

import umlgen.vue.Observateur;

public interface Sujet {
    public void enregistrerObservateur(Observateur o);
    public void supprimerObservateur(Observateur o);
    public void notifierObservateurs();
}
