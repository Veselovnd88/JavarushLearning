package my.learning.javarush.st3.cashmachine.command;

import my.learning.javarush.st3.cashmachine.exception.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException;

}
