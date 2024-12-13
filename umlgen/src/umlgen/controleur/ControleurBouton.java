package umlgen.controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import umlgen.ModeleDiagramme;

public class ControleurBouton implements EventHandler<ActionEvent> {

    private ModeleDiagramme modele;

    public ControleurBouton(ModeleDiagramme mod){
        modele=mod;
    }


    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
