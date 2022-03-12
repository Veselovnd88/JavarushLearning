package my.learning.javarush.st2.factorypattern;

import my.learning.javarush.st2.factorypattern.common.ImageReader;
import my.learning.javarush.st2.factorypattern.common.ImageTypes;

public class FactoryPatternTask {
    public static void task(){
        ImageReader reader = ImageReaderFactory.getImageReader(null);
        System.out.println(reader.getClass());
    }
}
