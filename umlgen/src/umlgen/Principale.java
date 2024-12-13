package umlgen;

import javafx.application.Application;
import javafx.stage.Stage;
import umlgen.controleur.ControleurBouton;
import umlgen.controleur.ControleurClavier;
import umlgen.controleur.ControleurDeplacement;
import umlgen.controleur.ControleurSouris;
import umlgen.vue.VueBouton;
import umlgen.vue.VueDiagramme;
import umlgen.vue.VueFleche;

public class Principale extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ModeleDiagramme modele;
        VueBouton vuebouton;
        VueDiagramme vuediagramme;
        VueFleche vuefleche;


        modele = new ModeleDiagramme();

        ControleurBouton controlbouton = new ControleurBouton(modele);
        ControleurClavier controlclavier = new ControleurClavier(modele);
        ControleurDeplacement controldeplacement = new ControleurDeplacement(modele);
        ControleurSouris controlSouris = new ControleurSouris(modele);


    }
}
