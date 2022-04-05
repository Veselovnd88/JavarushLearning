package my.learning.javarush.st2.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerTask {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try{ Object temp = objectStream.readObject();
            if (temp instanceof A){
                return (A) temp;
            }

        return null ;}
        catch (IOException | ClassNotFoundException c){


        return null;}
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void task(String[] args) {

    }
}
