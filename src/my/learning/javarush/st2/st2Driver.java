package my.learning.javarush.st2;

import my.learning.javarush.st2.aptekatask.AptekaTask;
import my.learning.javarush.st2.atm.Bankomat;
import my.learning.javarush.st2.atm.TransactionTask;
import my.learning.javarush.st2.factorypattern.FactoryPatternTask;

import java.io.FileInputStream;

public class st2Driver {


    public static void main(String[] args) throws Exception {
    if (args.length!=0){
    PricesTask.task(args[0],args);
    }
    //PricesTask.task("1", "1", "1", "1");
}}

