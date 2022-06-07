package my.learning.javarush.st3.cashmachine.command;

import my.learning.javarush.st3.cashmachine.CashMachine;
import my.learning.javarush.st3.cashmachine.ConsoleHelper;
import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName()+".resources.exit_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String answer = ConsoleHelper.readString();
        if(answer.equals("y")){
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }

    }
}
