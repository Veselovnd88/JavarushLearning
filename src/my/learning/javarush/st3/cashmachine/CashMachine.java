package my.learning.javarush.st3.cashmachine;

import my.learning.javarush.st3.cashmachine.command.CommandExecutor;
import my.learning.javarush.st3.cashmachine.command.LoginCommand;
import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);


        try {
            CommandExecutor.execute(Operation.LOGIN);

            Operation op = null;
            do {
                op = ConsoleHelper.askOperation();

                CommandExecutor.execute(op);
            } while (op != Operation.EXIT);

        } catch (InterruptOperationException io) {
            ConsoleHelper.writeMessage("До свидания");
        }
    }
}
