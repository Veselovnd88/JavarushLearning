package my.learning.javarush.arrays;

public class CheckLink {

    public static String checkProtocol(String url) {
        String result;
        if (url.startsWith("https")){
            result =  "https";
        }
        else if(url.startsWith("http")){
            result = "http";
        }
        else{
        result =  "неизвестный";}
        return result;
    }

    public static String checkDomain(String url) {
        String result;
        if(url.endsWith("com")){
            result = "com";
        }
        else if(url.endsWith("net")){
            result = "net";
        }
        else if(url.endsWith("org")){
            result  = "org";
        }
        else if( url.endsWith("ru")){
            result = "ru";
        }
        else {result ="неизвестный";}
        return result;
    }

}
