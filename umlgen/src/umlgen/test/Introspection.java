package umlgen.test;

import java.lang.reflect.*;

public class Introspection {
    private Class<?> classe;

    public Introspection(String nomClasse) {
        try {
            classe = Class.forName(nomClasse);
            System.out.println("Classe de l'objet chaine = " + classe.getName());
            Method[] methods = classe.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Méthode : " + method.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Introspection("umlgen.test.test");
    }
}
