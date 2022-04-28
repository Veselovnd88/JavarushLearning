package my.learning.javarush.st3.generiks;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.Set;

public class Sol {



    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Sol.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Sol.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Path p = Path.of(pathToAnimals);

        return null;
    }
}

