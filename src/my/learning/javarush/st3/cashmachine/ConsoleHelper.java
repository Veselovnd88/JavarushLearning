package my.learning.javarush.st3.cashmachine;

import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException {
        String str=null;
        try{
            str = bis.readLine();


        }catch (Exception e){
            e.printStackTrace();
        }            if(str.toLowerCase().equals("exit")){
                        throw new InterruptOperationException();
        }

        return str;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
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
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

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

    public static int getOneDigit() throws InterruptOperationException {
        boolean flag = true;
        int value=-1;
        ConsoleHelper.writeMessage("Введите сумму");
        do{
            String sum = ConsoleHelper.readString();
            try{
                value = Integer.parseInt(sum);

                flag = false;
                return value;}
            catch (NumberFormatException e){

                System.out.println("Сумма введена неверно");
            }

        } while(flag);
        return value;
    }

    public static Operation askOperation() throws InterruptOperationException {
        System.out.println("Введите номер для операции: для 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;");
        String str = readString();
        Operation op=null;
        int num =0;
        while(true){
            try{
                num = Integer.parseInt(str);
                op = Operation.getAllowableOperationByOrdinal(num);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Введено не число");
                str= readString();
            } catch (IllegalArgumentException e){
                System.out.println("Нет операции с заданным номером");
                str = readString();
            }
        } return op;
    }
}
