package my.learning.javarush.st3.cashmachine.command;

import my.learning.javarush.st3.cashmachine.CashMachine;
import my.learning.javarush.st3.cashmachine.ConsoleHelper;
import my.learning.javarush.st3.cashmachine.CurrencyManipulator;
import my.learning.javarush.st3.cashmachine.CurrencyManipulatorFactory;
import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName()+".resources.deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String curr = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curr);
        String[] strings = ConsoleHelper.getValidTwoDigits(curr);
        try{
            int denomination = Integer.parseInt(strings[0]);
            int count = Integer.parseInt(strings[1]);
            cm.addAmount(denomination, count);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), (denomination * count), curr));
        }
        catch (NumberFormatException e){
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }

       // System.out.println(cm.getTotalAmount());
    }
}
