package umlgen.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import umlgen.ModeleDiagramme;

public class ControleurDeplacement implements EventHandler<DragEvent> {

    private ModeleDiagramme modele;

    public ControleurDeplacement(ModeleDiagramme modele) {
        this.modele = modele;
    }

    @Override
    public void handle(DragEvent event) {
    }

}
