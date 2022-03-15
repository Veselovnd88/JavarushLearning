package my.learning.javarush.st2.crudtask1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CrudTask2 {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        SimpleDateFormat out = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int id;
        String name;
        String sex;
        Person p;
        switch (args[0]){
            case "-c":
                synchronized (allPeople){
                for (int i=0; i< args.length-1;i+=3){
                    if(args[i+2].equals("м")){
                        try{
                        allPeople.add(Person.createMale(args[i+1],ft.parse(args[i+3])));
                     }
                        catch (ParseException e){
                            e.printStackTrace();
                        }
                        } else {
                            try{
                            allPeople.add(Person.createFemale(args[i+1],ft.parse(args[i+3])));
                        }
                        catch (ParseException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println(allPeople.size()-1);}
                    break;}
            case "-i":
                synchronized (allPeople){
                for (int i=0; i< args.length-1;i++){
                id = Integer.parseInt(args[i+1]);
                name = allPeople.get(id).getName();
                if (allPeople.get(id).getSex()==Sex.MALE){
                    sex = "м";
                } else {sex = "ж";}
                String date = out.format(allPeople.get(id).getBirthDate());
                System.out.printf("%s %s %s%n",name,sex,date);
                }
                break;}
            case "-u":
                synchronized (allPeople){
                for (int i=0; i< args.length-1;i+=4){
                id = Integer.parseInt(args[i+1]);
                name = args[i+2];
                sex = args[i+3];
                p = allPeople.get(id);
                p.setName(name);
                if (sex.equals("м")){
                    p.setSex(Sex.MALE);
                } else {p.setSex(Sex.FEMALE);}
                try {
                    p.setBirthDate(ft.parse(args[i+4]));
                }catch (ParseException e){
                    e.printStackTrace();
                }//System.out.println(p.getName());
                    //System.out.println(p.getSex());
                }

                break;}
            case "-d":
                synchronized (allPeople){
                for (int i=0; i< args.length-1; i++){
                id = Integer.parseInt(args[i+1]);
                p = allPeople.get(id);
                p.setName(null);
                p.setSex(null);
                p.setBirthDate(null);
                //System.out.println(p.getName());
                //System.out.println(p.getSex());
                    }}
        }

    }
}
