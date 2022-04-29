package my.learning.javarush.st3.factoryPattern.male;

import my.learning.javarush.st3.factoryPattern.Human;

public class MaleFactory {
    public Human getPerson(int age){
        if(age<=KidBoy.MAX_AGE){
            Human boy = new KidBoy();
            return boy;
        }
        else if (age<=TeenBoy.MAX_AGE){
            Human teen = new TeenBoy();
            return teen;
        }
        else{
            return new Man();
        }


    }

}
