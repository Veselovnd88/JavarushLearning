package my.learning.javarush.st3.cashmachine;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);


        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        String[] strings = ConsoleHelper.getValidTwoDigits(null);
        cm.addAmount(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));

    }
}
