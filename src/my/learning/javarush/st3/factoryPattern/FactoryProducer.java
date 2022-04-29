package my.learning.javarush.st3.factoryPattern;

import my.learning.javarush.st3.factoryPattern.female.FemaleFactory;
import my.learning.javarush.st3.factoryPattern.male.MaleFactory;

public class FactoryProducer {

    public static enum HumanFactoryType{
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type){
        if(type == HumanFactoryType.MALE){
            return new MaleFactory();
        }

        return new FemaleFactory();
    }
}
