package umlgen.fleches;

import umlgen.ClasseEntiere;

public abstract class Fleche {

    protected ClasseEntiere source;
    protected ClasseEntiere cible;

    public Fleche(ClasseEntiere s, ClasseEntiere c){
        this.source = s;
        this.cible = c;
    }

    public abstract String getTypeRelation();
}
