package my.learning.javarush.st3.cashmachine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

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


    public Map<Integer,Integer> withdrawAmount(int expectedAmount){
        TreeSet<Integer> denomins = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2)*-1;
            }
        });
        denominations.forEach((x,y)->{
            denomins.add(x);
        });
        int sum = getTotalAmount();
        int got = 0;
        HashMap<Integer,Integer> withdrawals = new HashMap<>();

            for(Integer i: denomins){
                int received =greedySum(i,sum,withdrawals);
                sum-=received;
                got+=received;
                if(sum<0|| got>=expectedAmount){
                    break;
                }
        }
        System.out.println(withdrawals);
        return null;
    }
    private int greedySum(int nominal, int left, Map<Integer,Integer> wit){
        int qnt = left/nominal;
        if(qnt==0){
            return 0;
        }
        if(qnt<=denominations.get(nominal)){
            wit.put(nominal,qnt);
            return nominal*qnt;
        }else{
            wit.put(nominal,denominations.get(nominal));
            return nominal*denominations.get(nominal);
        }
    }
}
