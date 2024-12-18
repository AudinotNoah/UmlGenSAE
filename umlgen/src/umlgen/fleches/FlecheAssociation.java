package umlgen.fleches;

import umlgen.ClasseEntiere;

public class FlecheAssociation extends Fleche{

    public FlecheAssociation(ClasseEntiere s, ClasseEntiere c){
        super(s, c);
    }

    public String getTypeRelation(){
        return "Association";
    }
}
