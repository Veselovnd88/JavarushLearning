package my.learning.javarush.st2;

import java.util.ArrayList;
import java.util.List;

public class MoneyTask {
    public static void task(){
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
           this.allMoney.add(new Hryvnia(500));
           this.allMoney.add(new USD(1000));
           this.allMoney.add(new Ruble(10000));
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
