package umlgen.test;

import java.lang.reflect.*;
import java.util.ArrayList;
import umlgen.*;
import umlgen.status.Abstract;
import umlgen.status.Final;
import umlgen.status.Static;
import umlgen.type.Classe;
import umlgen.type.Enum;
import umlgen.type.Interface;
import umlgen.visibilite.*;
import umlgen.status.Status;

public class Introspection {
    private Class<?> classe;

    public Introspection(String nomClasse) {
        try {
            // Charger la classe à partir de son nom
            classe = Class.forName(nomClasse);
            System.out.println("Classe de l'objet : " + classe.getName());

            ArrayList<Methode> methodes = new ArrayList<>();
            ArrayList<Attribut> attributs = new ArrayList<>();

            umlgen.type.Type t;
            if (classe.isInterface()) {
                t = new Interface();
            } else if (classe.isEnum()) {
                t = new Enum();
            } else {
               t = new Classe();
            }
            int classModifiers = classe.getModifiers();

            getStatus(classModifiers);
//            ClasseEntiere c = new ClasseEntiere(classe.getName(),getVisibility(classModifiers),t,)

            Method[] methods = classe.getDeclaredMethods();
            for (Method method : methods) {
                int modifiers = method.getModifiers();


                Class<?>[] paramTypes = method.getParameterTypes();

                ArrayList<Attribut> parasMethode = new ArrayList<>();
                for (Class<?> paramType : paramTypes) {
                    Attribut a =  new Attribut(paramType.getName(),paramType);
                    parasMethode.add(a);
                }


                Methode m =  new Methode(method.getName(),getVisibility(modifiers),getStatus(modifiers), method.getReturnType(),parasMethode);
                methodes.add(m);
            }

//
//            // Créer un attribut avec un nom, visibilite, status et un type (ex. String)
//            Attribut attribut1 = new Attribut("attribut1", visibilite, statusList, String.class);
//            attributs.add(attribut1);
//
//            // Créer une méthode
//            ArrayList<Attribut> params = new ArrayList<>();
//            params.add(new Attribut("param1", Integer.class));
//            Methode methode1 = new Methode("methode1", String.class, params);
//            methodes.add(methode1);
//
//            // Créer l'objet ClasseEntiere avec des attributs et des méthodes
//            ClasseEntiere classeEntiere = new ClasseEntiere("TestClass", new Public(), methodes, attributs);
//
//            // Afficher les attributs de ClasseEntiere
//            Field[] fields = classeEntiere.getClass().getDeclaredFields();
//            System.out.println("\nAttributs de ClasseEntiere :");
//            for (Field field : fields) {
//                System.out.println("Attribut : " + field.getName() + " | Type : " + field.getType().getName());
//            }
//
//            // Afficher les méthodes de ClasseEntiere
//            Method[] methods = classeEntiere.getClass().getDeclaredMethods();
//            System.out.println("\nMéthodes de ClasseEntiere :");
//            for (Method method : methods) {
//                System.out.println("Méthode : " + method.getName() + " | Retour : " + method.getReturnType().getName());
//            }
//
//
//            // Créer et inspecter un objet de la classe Attribut
//            if (classe.getSimpleName().equals("Attribut")) {
//                // Créer un objet Visibilite
//                Visibilite visibilite = new Public();
//                ArrayList<Status> statusList = new ArrayList<>();
//                // Créer un attribut avec un nom, visibilite, status et un type
//                Attribut attribut = new Attribut("attribut1", visibilite, statusList, String.class);
//                System.out.println("\nAttribut : " + attribut.getNom() + " | Type : " + attribut.getType());
//            }
//
//            // Créer et inspecter un objet de la classe Methode
//            if (classe.getSimpleName().equals("Methode")) {
//                ArrayList<Attribut> params = new ArrayList<>();
//                params.add(new Attribut("param1", Integer.class));
//                Methode methode = new Methode("methode1", String.class, params);
//                System.out.println("\nMéthode : " + methode.getNom() + " | Type Retour : " + methode.getTypeRetour());
//                for (Attribut param : methode.getParametres()) {
//                    System.out.println("Paramètre : " + param.getNom() + " | Type : " + param.getType());
//                }
//            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Visibilite getVisibility(int modifiers) {
        if (Modifier.isProtected(modifiers)) {
            return new Protected();
        } else if (Modifier.isPrivate(modifiers)) {
            return new Private();
        } else {
            return new Public();
        }
    }
    public static ArrayList<Status> getStatus(int modifiers) {
        ArrayList<Status> statusList = new ArrayList<>();

        if (Modifier.isStatic(modifiers)) statusList.add(new Static());
        if (Modifier.isFinal(modifiers)) statusList.add(new Final());
        if (Modifier.isAbstract(modifiers)) statusList.add(new Abstract());

        return statusList;
    }
    public static void main(String[] args) {
        new Introspection("umlgen.test.Test");
    }
}
