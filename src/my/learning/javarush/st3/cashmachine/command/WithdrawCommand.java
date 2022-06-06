package my.learning.javarush.st3.cashmachine.command;

import my.learning.javarush.st3.cashmachine.ConsoleHelper;
import my.learning.javarush.st3.cashmachine.CurrencyManipulator;
import my.learning.javarush.st3.cashmachine.CurrencyManipulatorFactory;
import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;
import my.learning.javarush.st3.cashmachine.exception.NotEnoughMoneyException;

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

    }
}
