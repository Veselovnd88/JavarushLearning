package my.learning.javarush.st3.cashmachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        String str=null;
        try{
            str = bis.readLine();

        }catch (Exception e){
            e.printStackTrace();
        }return str;
    }

    public static String askCurrencyCode(){
        System.out.println("Введите код валюты, 3 символа");
        String str = readString();
        while(true){
        if (str.length()!=3){
            System.out.println("Неправильный ввод, введите еще раз");
            str = readString();
        }
        else{
            break;
        }
    } return str.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode){

        System.out.println("Введите два положительных числа: номинал и количество");
        String str=readString();
        while (true){
            String[] parts = str.split(" ");
            if(parts.length!=2){
                System.out.println("Введите 2 числа");
                str = readString();
            }
            else{
                boolean flag = true;
                for(int i=0; i<str.length(); i++){
                    if(!Character.isDigit(str.charAt(i))&&str.charAt(i)!=' '){
                        flag = false;
                    }
                }
                if(flag){
                    return parts;
                }else{
                    System.out.println("Есть не только цифры");
                    str = readString();
                }
            }
    }
    }
}
