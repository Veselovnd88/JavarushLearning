package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MovieTask {
    public static void task() throws Exception {
        String key;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> l = new ArrayList<>();
        l.add("soapOpera");
        l.add("cartoon");
        l.add("thriller");
        do{
            key = br.readLine();
            MovieFactory.getMovie(key);}
        while (l.contains(key));

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
                System.out.println(movie.getClass().getSimpleName());
            }
            if ("cartoon".equals(key)){
                movie = new Cartoon();
                System.out.println(movie.getClass().getSimpleName());
            }
            if ("thriller".equals(key)){
                movie = new Thriller();
                System.out.println(movie.getClass().getSimpleName());
            }



            //напишите тут ваш код, пункты 5,6
            // System.out.println(movie.getClass().getSimpleName());
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{

    }
    static class Thriller extends Movie{

    }




}
