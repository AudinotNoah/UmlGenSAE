package umlgen.fleches;

import umlgen.ClasseEntiere;

public class FlecheHeritage extends Fleche{

    public FlecheHeritage(ClasseEntiere s, ClasseEntiere c){
        super(s, c);
    }

    public String getTypeRelation(){
        return "Heritage";
    }
}
