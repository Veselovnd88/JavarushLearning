package my.learning.javarush.st2.bonustasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Huan {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void task(String[] args){

        String file = args[0];
        try{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()){
            String[] parts = br.readLine().split(" ");
            int year = Integer.parseInt(parts[parts.length-1]);
            int month = Integer.parseInt(parts[parts.length-2]);
            int day = Integer.parseInt(parts[parts.length-3]);
            StringBuilder sb = new StringBuilder();
            for (int i=0; i< parts.length-3;i++){
                if(i!=0){
                    sb.append(" ");
                }
                sb.append(parts[i]);
            }
            String name = sb.toString();
            Calendar date = new GregorianCalendar(year,month-1,day);

            Date birthDate = date.getTime();
            PEOPLE.add(new Person(name,birthDate));
        }
        fr.close();
        br.close();
        //PEOPLE.forEach(x->{
            //System.out.println(x.getName()+"-"+ x.getBirthDate());
        //});

        }


        catch ( Exception e){
            e.printStackTrace();
        }


    }


}
