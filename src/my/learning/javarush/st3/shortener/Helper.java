package my.learning.javarush.st3.shortener;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {

    public static  String generateRandomString(){

        SecureRandom sr = new SecureRandom();
        return new BigInteger(130, sr).toString(32);
    }

    public static void  printMessage(String message){
        System.out.println(message);
    }
}
