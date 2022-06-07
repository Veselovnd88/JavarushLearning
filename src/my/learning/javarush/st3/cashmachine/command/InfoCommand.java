package my.learning.javarush.st3.cashmachine.command;


import my.learning.javarush.st3.cashmachine.CashMachine;
import my.learning.javarush.st3.cashmachine.ConsoleHelper;
import my.learning.javarush.st3.cashmachine.CurrencyManipulator;
import my.learning.javarush.st3.cashmachine.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;

class InfoCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName()+".resources.info_en");
    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> map = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (map.size()==0){
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
        else{
            map.forEach(x->{
                if(x.hasMoney()){
                    System.out.println(x.getCurrencyCode().toUpperCase()+" - "+x.getTotalAmount());}
                else{
                    ConsoleHelper.writeMessage(res.getString("no.money"));
                }
            });
        }
    }
}
