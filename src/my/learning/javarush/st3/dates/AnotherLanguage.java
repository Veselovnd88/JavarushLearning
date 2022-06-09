package my.learning.javarush.st3.dates;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AnotherLanguage {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }



    public static String getWeekdayOfBirthday(String birthday, String year) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("y");
        LocalDate date = LocalDate.parse(birthday,formatter);
        Year year1 = Year.parse(year,yearFormat);
        return date.withYear(year1.getValue()).format(DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ITALIAN));





            }
}
