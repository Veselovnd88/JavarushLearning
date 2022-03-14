package my.learning.javarush.st2.crudtask1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrudTask1 {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
            if(args[0].equals("-c")){
                if(args[2].equals("м")){
                    allPeople.add(Person.createMale(args[1],))
                }
            }
    }
}
