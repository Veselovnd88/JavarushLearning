package my.learning.javarush.st3.cashmachine.command;

import my.learning.javarush.st3.cashmachine.ConsoleHelper;
import my.learning.javarush.st3.cashmachine.CurrencyManipulator;
import my.learning.javarush.st3.cashmachine.CurrencyManipulatorFactory;
import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;

class DepositCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
        String curr = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curr);
        String[] strings = ConsoleHelper.getValidTwoDigits(curr);
        cm.addAmount(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
        System.out.println(cm.getTotalAmount());
    }
}
