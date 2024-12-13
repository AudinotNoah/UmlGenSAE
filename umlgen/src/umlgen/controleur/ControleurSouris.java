package umlgen.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import umlgen.ModeleDiagramme;

public class ControleurSouris implements EventHandler<MouseEvent> {

    private ModeleDiagramme modele;

    public ControleurSouris(ModeleDiagramme modele) {
        this.modele = modele;
    }

    @Override
    public void handle(MouseEvent event) {
    }

}