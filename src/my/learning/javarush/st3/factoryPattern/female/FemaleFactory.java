package my.learning.javarush.st3.factoryPattern.female;

import my.learning.javarush.st3.factoryPattern.AbstractFactory;
import my.learning.javarush.st3.factoryPattern.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age){
        if(age<= KidGirl.MAX_AGE){
            Human boy = new KidGirl();
            return boy;
        }
        else if (age<= TeenGirl.MAX_AGE){
            Human teen = new TeenGirl();
            return teen;
        }
        else{
            return new Woman();
        }


    }

}
