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

            umlgen.type.Type typeClasse;
            if (classe.isInterface()) {
                typeClasse = new Interface();
            } else if (classe.isEnum()) {
                typeClasse = new Enum();
            } else {
                typeClasse = new Classe();
            }
            int classModifiers = classe.getModifiers();

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
            Field[] fields = classe.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();

                Attribut attribut = new Attribut(
                        field.getName(),
                        getVisibility(modifiers),
                        getStatus(modifiers),
                        field.getType()
                );
                attributs.add(attribut);
            }


            ClasseEntiere c = new ClasseEntiere(classe.getName(),getVisibility(classModifiers),typeClasse,methodes,attributs,getStatus(classModifiers));
            System.out.println(c.toString());



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
