package my.learning.javarush.arrays;

import java.util.Date;
import java.util.List;


public class PlayDate {
    static Date birthDate = new Date(88,12,6);
    public static String getDayofWeek(Date date){
        String[] days = new String[] {"Воскресенье","Понедельник","Вторник","Среда","Четверг", "Пятница","Суббота"};
        return days[date.getDay()];}
        static void fixDate(List<Date> brokenDates) {
        Date current = new Date();
        brokenDates.forEach(date->
        { if(date.after(current)){
            date.setYear(date.getYear()-1900);
            date.setMonth(date.getMonth()-1);
        }
            });
    }




}
