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
        int sum = ConsoleHelper.getOneDigit();
        while(true){
        if(cm.isAmountAvailable(sum)){
            break;
        }
        else{
            sum = ConsoleHelper.getOneDigit();
        }}
        Map<Integer, Integer> mp = cm.withdrawAmount(sum);
        TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2)*-1;
            }


        });
        sortedMap.forEach((x,y)->{
                    System.out.println(x+" - "+ y);
                }
                );
        ConsoleHelper.writeMessage("Операция проведена успешно");


    }
}
