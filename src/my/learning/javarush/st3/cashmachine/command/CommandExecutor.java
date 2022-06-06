package my.learning.javarush.st3.cashmachine.command;

import my.learning.javarush.st3.cashmachine.Operation;
import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation,Command> allKnownCommandsMap = new HashMap<>();
    static {//инициализировали
        allKnownCommandsMap.put(Operation.WITHDRAW, new WithdrawCommand());
        allKnownCommandsMap.put(Operation.DEPOSIT,new DepositCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
    }

    private CommandExecutor(){};

    public static final void execute(Operation operation) throws InterruptOperationException {
        allKnownCommandsMap.get(operation).execute();
    }
}
