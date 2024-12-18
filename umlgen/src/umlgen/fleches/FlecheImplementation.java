package umlgen.fleches;

import umlgen.ClasseEntiere;

public class FlecheImplementation extends Fleche{

    public FlecheImplementation(ClasseEntiere s, ClasseEntiere c){
        super(s, c);
    }

    public String getTypeRelation(){
        return "Implementation";
    }
}
