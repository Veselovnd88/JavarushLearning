package my.learning.javarush.st3.cashmachine;

import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static  ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName()+".resources.common_en");
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
        ConsoleHelper.writeMessage(res.getString("choose.currency.code"));
        String str = readString();
        while(true){
        if (str.length()!=3){
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
            str = readString();
        }
        else{
            break;
        }
    } return str.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("choose.denomination.and.count.format"));
        String str=readString();
        while (true){
            String[] parts = str.split(" ");
            if(parts.length!=2){
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
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
                    ConsoleHelper.writeMessage(res.getString("invalid.data"));
                    str = readString();
                }
            }
    }
    }

    public static int getOneDigit() throws InterruptOperationException {
        boolean flag = true;
        int value=-1;
        ConsoleHelper.writeMessage(res.getString("choose.denomination.and.count.format"));
        do{
            String sum = ConsoleHelper.readString();
            try{
                value = Integer.parseInt(sum);

                flag = false;
                return value;}
            catch (NumberFormatException e){

                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }

        } while(flag);
        return value;
    }

    public static Operation askOperation() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("choose.operation"));
        ConsoleHelper.writeMessage("1- "+ res.getString("operation.INFO"));
        ConsoleHelper.writeMessage("2- "+ res.getString("operation.DEPOSIT"));
        ConsoleHelper.writeMessage("3- "+ res.getString("operation.WITHDRAW"));
        ConsoleHelper.writeMessage("4- "+ res.getString("operation.EXIT"));
        String str = readString();
        Operation op=null;
        int num =0;
        while(true){
            try{
                num = Integer.parseInt(str);
                op = Operation.getAllowableOperationByOrdinal(num);
                break;
            } catch (IllegalArgumentException e){
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                str= readString();
            }
        } return op;
    }
    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
