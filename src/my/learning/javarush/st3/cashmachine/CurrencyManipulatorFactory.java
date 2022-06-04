package my.learning.javarush.st3.cashmachine;

import java.util.HashMap;
import java.util.Map;

public  class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory(){
    }
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if(map.containsKey(currencyCode.toLowerCase())){
            return map.get(currencyCode.toLowerCase());
        }
        else{
            CurrencyManipulator cm = new CurrencyManipulator(currencyCode.toLowerCase());
            map.put(currencyCode.toLowerCase(),cm);
            return cm;
        }
    }
}
