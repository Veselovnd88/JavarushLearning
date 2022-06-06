package my.learning.javarush.st3.cashmachine;

import my.learning.javarush.st3.cashmachine.command.CommandExecutor;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation op=null;
        do {
            op = ConsoleHelper.askOperation();
            CommandExecutor.execute(op);
        }
        while(op!=Operation.EXIT);
    }
}
