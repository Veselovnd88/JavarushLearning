package my.learning.javarush.st3.shortener;

public class ExceptionHandler {

    public static void log(Exception e){
        Helper.printMessage(e.toString());
    }
}
