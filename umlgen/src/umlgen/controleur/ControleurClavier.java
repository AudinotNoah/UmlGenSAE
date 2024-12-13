package umlgen.controleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import umlgen.ModeleDiagramme;

public class ControleurClavier implements EventHandler<KeyEvent> {

    private ModeleDiagramme modele;

    public ControleurClavier(ModeleDiagramme modele) {
        this.modele = modele;
    }

    @Override
    public void handle(KeyEvent event) {
    }

}