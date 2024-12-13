package umlgen;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

interface Component {
    void printInfo();
}

class FileComponent implements Component {
    private File file;
    private ClassLoader classLoader;

    public FileComponent(File file, ClassLoader classLoader) {
        this.file = file;
        this.classLoader = classLoader;
    }

    @Override
    public void printInfo() {
        if (file.getName().endsWith(".java")) {
            System.out.println("Introspection du fichier : " + file.getName());
            printMethods(file);
        }
    }

    private void printMethods(File file) {
        try {
            // Nom de la classe sans l'extension .java
            String className = file.getName().replace(".java", "");
            // Charger dynamiquement la classe compilée
            Class<?> clazz = classLoader.loadClass(className);
            System.out.println("Méthodes de la classe " + clazz.getName() + " : ");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(" - " + method.getName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Impossible de trouver la classe pour le fichier " + file.getName());
            e.printStackTrace();
        }
    }
}

class DirectoryComponent implements Component {
    private File directory;
    private List<Component> components = new ArrayList<>();
    private ClassLoader classLoader;

    public DirectoryComponent(File directory, ClassLoader classLoader) {
        this.directory = directory;
        this.classLoader = classLoader;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void printInfo() {
        if (directory.isDirectory()) {
            System.out.println("Exploration du répertoire : " + directory.getName());
            for (Component component : components) {
                component.printInfo();
            }
        }
    }

    public void exploreDirectory() {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                DirectoryComponent subDirectory = new DirectoryComponent(file, classLoader);
                addComponent(subDirectory);
                subDirectory.exploreDirectory();
            } else {
                addComponent(new FileComponent(file, classLoader));
            }
        }
    }
}

class JavaFileIntrospector {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\audin\\Desktop\\cours\\quali\\observateur\\Observateur";  // Remplacez par votre chemin
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            try {
                // Créer un class loader pour charger les fichiers .class dans le répertoire
                File classesDir = new File(directoryPath);  // Répertoire contenant les classes compilées
                URL[] urls = { classesDir.toURI().toURL() };
                URLClassLoader classLoader = new URLClassLoader(urls);

                DirectoryComponent root = new DirectoryComponent(directory, classLoader);
                root.exploreDirectory();
                root.printInfo();
            } catch (Exception e) {
                System.out.println("Erreur lors du chargement des classes : " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Le répertoire spécifié n'existe pas.");
        }
    }
}
class TestClassLoading {
    public static void main(String[] args) {
        try {
            // Modifier le chemin pour pointer vers le répertoire de vos fichiers .class
            URL[] urls = { new File("chemin/vers/classes").toURI().toURL() };
            URLClassLoader classLoader = new URLClassLoader(urls);

            // Exemple de tentative de chargement d'une classe
            Class<?> clazz = classLoader.loadClass("Controler");
            System.out.println("Classe chargée : " + clazz.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
