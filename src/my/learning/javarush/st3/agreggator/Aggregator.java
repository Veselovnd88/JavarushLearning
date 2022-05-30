package my.learning.javarush.st3.agreggator;

import my.learning.javarush.st3.agreggator.model.HHStrategy;
import my.learning.javarush.st3.agreggator.model.Provider;

import java.io.IOException;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(new HHStrategy());
        Controller controller = new Controller(provider);
        controller.scan();
    }
}
