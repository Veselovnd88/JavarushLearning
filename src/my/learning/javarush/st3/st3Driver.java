package my.learning.javarush.st3;

import my.learning.javarush.st3.remot.TrainingRMI;
import my.learning.javarush.st3.remot.TrainingRMI2;
import my.learning.javarush.st3.remot.sloc.ServiceLocatorTask;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class st3Driver {
    public static void main(String[] args) throws Exception {
        ServiceLocatorTask.task();

    }
}
