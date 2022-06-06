package my.learning.javarush.st3.cashmachine.command;


import my.learning.javarush.st3.cashmachine.CurrencyManipulator;
import my.learning.javarush.st3.cashmachine.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Map;

class InfoCommand implements Command{
    @Override
    public void execute() {
        Collection<CurrencyManipulator> map = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (map.size()==0){
            System.out.println("No money available.");
        }
        else{
            map.forEach(x->{
                if(x.hasMoney()){
                    System.out.println(x.getCurrencyCode().toUpperCase()+" - "+x.getTotalAmount());}
                else{
                    System.out.println("No money available.");
                }
            });
        }
    }
}
