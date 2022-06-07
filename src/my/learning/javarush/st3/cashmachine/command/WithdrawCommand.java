package my.learning.javarush.st3.cashmachine.command;

import my.learning.javarush.st3.cashmachine.ConsoleHelper;
import my.learning.javarush.st3.cashmachine.CurrencyManipulator;
import my.learning.javarush.st3.cashmachine.CurrencyManipulatorFactory;
import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;
import my.learning.javarush.st3.cashmachine.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class WithdrawCommand implements Command{

    @Override
    public void execute() throws InterruptOperationException {
        String curr =ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curr);
        boolean flag = true;
        int value=-1;
        ConsoleHelper.writeMessage("Введите сумму");
        do{
            String sum = ConsoleHelper.readString();
            try{
                value = Integer.parseInt(sum);

                flag = false;
                break;}
            catch (NumberFormatException e){

                System.out.println("Сумма введена неверно");
            }

        } while(flag);
        int sum = value;



        //int sum = ConsoleHelper.getOneDigit();
        while(true){
        if(cm.isAmountAvailable(sum)){
            break;
        }
        else{
            sum = ConsoleHelper.getOneDigit();
        }}
        try{
        Map<Integer, Integer> mp = cm.withdrawAmount(sum);
        TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2)*-1;
            }
        });
        sortedMap.putAll(mp);
        sortedMap.forEach((x,y)->{
                    System.out.println(x+" - "+ y);
                }
                );
        ConsoleHelper.writeMessage("Операция проведена успешно");
        }
        catch (NotEnoughMoneyException e){
            System.out.println("Нет возможности выдать указанную сумму");
        }
    }
}
