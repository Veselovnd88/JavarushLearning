package my.learning.javarush.st3.cashmachine;

import my.learning.javarush.st3.cashmachine.exception.NotEnoughMoneyException;

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


    public Map<Integer,Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        TreeSet<Integer> denomins = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2)*-1;
            }
        });// сет для доступных номиналов по убыванию - для итерации
        denominations.forEach((x,y)->{
            denomins.add(x);
        });
        int sum = getTotalAmount();//полная сумма
        int got = 0;//получено
        /*Что должно делать - берем полную сумму - делим на максимальный номинал - получаем сумму банкнот которую
        нам могут выдать.
        если запрашиваемая сумма меньше чем номинал - то эти банкноты пропускаем
        * */

        HashMap<Integer,Integer> withdrawals = new HashMap<>();
            for(Integer i: denomins){
                if(expectedAmount<i){
                    continue;//если меньше запрашиваемого - то проускаем
                }
                int received =greedySum(i,sum,withdrawals);// сколько денег получили (гипотетически)
                if(got+received>expectedAmount){
                    continue;
                }
                else{
                    sum-=received;
                    got+=received;
                }
                if(got==expectedAmount){
                    break;
                }
        }

        System.out.println(withdrawals);
            if(withdrawals.size()==0||got<expectedAmount){
                throw new NotEnoughMoneyException();
            }

            for(Integer nominal : denominations.keySet()){
                if(withdrawals.containsKey(nominal)){
                    int value = denominations.get(nominal) - withdrawals.get(nominal);
                    denominations.put(nominal,value);
                }
            }
        return withdrawals;
    }
    private int greedySum(int nominal, int left, Map<Integer,Integer> wit){

        int qnt = left/nominal;// количество возможных купюр
        if(qnt==0){
            return 0;
        }
        if(qnt<=denominations.get(nominal)){//если количество меньше возможных
            wit.put(nominal,qnt);//возвращаем ввсе
            return nominal*qnt;
        }else{
            wit.put(nominal,denominations.get(nominal));//если меньше - то отдаем всё что есть
            return nominal*denominations.get(nominal);
        }
    }
}
