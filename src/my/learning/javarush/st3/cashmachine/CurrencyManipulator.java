package my.learning.javarush.st3.cashmachine;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer,Integer> denominations=new HashMap<>();


    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode(){
        return currencyCode;
    }
    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination)){
            int value = denominations.get(denomination)+count;
            denominations.put(denomination,value);
        }
        else{
            denominations.put(denomination,count);}
    }
    public boolean hasMoney(){
        if (getTotalAmount()==0){
            return false;
        } return true;
    }


    public boolean isAmountAvailable(int expected){
        if(expected<=getTotalAmount()){

            return true;
        }
        return false;
    }


    public int getTotalAmount(){
        int count =0;
        for(Map.Entry<Integer,Integer> entry: denominations.entrySet()){
            count= count+ entry.getKey()* entry.getValue();
        }
        return count;
    }
    public Map<Integer, Integer> getDenominations() {
        return denominations;
    }


    private Map<Integer,Integer> withdrawAmount(int expectedAmount){
        return null;
    }
}
