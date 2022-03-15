package my.learning.javarush.st2.crudtask1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CrudTask1 {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        SimpleDateFormat out = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            if(args[0].equals("-c")){
                if(args[2].equals("м")){
                    try{
                    allPeople.add(Person.createMale(args[1],ft.parse(args[3])));
                    }
                    catch (ParseException e){
                        e.printStackTrace();
                        }

                } else {
                    try{
                        allPeople.add(Person.createFemale(args[1],ft.parse(args[3])));
                        }
                    catch (ParseException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(allPeople.size()-1);

            }
            else if(args[0].equals("-r")){
                int id = Integer.parseInt(args[1]);
                String name = allPeople.get(id).getName();
                String sex;
                if (allPeople.get(id).getSex()==Sex.MALE){
                    sex = "м";
                } else {sex = "ж";}
                String date = out.format(allPeople.get(id).getBirthDate());
                System.out.printf("%s %s %s",name,sex,date);
            }
            else if (args[0].equals("-u")){
                int id = Integer.parseInt(args[1]);
                String name = args[2];
                String sex = args[3];
                Person p = allPeople.get(id);
                p.setName(name);
                if (sex.equals("м")){
                    p.setSex(Sex.MALE);
                } else {p.setSex(Sex.FEMALE);}
                try {
                        p.setBirthDate(ft.parse(args[4]));
                    }catch (ParseException e){
                        e.printStackTrace();
                    }
                //System.out.println(p.getName());
               //System.out.println(p.getSex());
            }
            else if (args[0].equals("-d")){
                int id = Integer.parseInt(args[1]);

                Person p = allPeople.get(id);
                p.setName(null);
                p.setSex(null);
                p.setBirthDate(null);
                //System.out.println(p.getName());
                //System.out.println(p.getSex());
                             }



    }
}
