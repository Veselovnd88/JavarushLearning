package my.learning.javarush.st3.cashmachine.command;

import my.learning.javarush.st3.cashmachine.ConsoleHelper;
import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;

class ExitCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
        System.out.println("Вы действительно хотите выйти y/n?");
        String answer = ConsoleHelper.readString();
        if(answer.equals("y")){
            ConsoleHelper.writeMessage("До свидания");
        }else{

        }

    }
}
