package my.learning.javarush.arrays;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;


public class PlayDate {
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;
    private static final int WEEKEND_START_FRIDAY_CUT_OFF_HOUR = 22;
    private static final int WEEKEND_END_SUNDAY_CUT_OFF_HOUR = 23;

    public static String getDayofWeekOld(Date date){
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

    public static String getDayOfWeek(LocalDate date) {
        //напишите тут ваш код

        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"));
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        Set<LocalDateTime> myset = new HashSet<>();
        sourceMap.forEach((k, v)  ->{
            v.forEach(t ->{
                LocalDateTime time = LocalDateTime.of(k,t);
                myset.add(time);
            });

        });

        return myset;
    }
    static boolean isWeekend(LocalDateTime time){
        if(time.getDayOfWeek().getValue()>=5 && time.getDayOfWeek().getValue()<=7 ){
            if(time.getDayOfWeek().getValue()==5){
                if (time.getHour()>=WEEKEND_START_FRIDAY_CUT_OFF_HOUR){
                    return true;
                }
            }
            else if(time.getDayOfWeek().getValue()==6){
                return true;
            }
            else if(time.getDayOfWeek().getValue()==7){
                if(time.getHour()<WEEKEND_END_SUNDAY_CUT_OFF_HOUR){
                    return  true;
                }
            }
        } return false;
    }

    static Instant getMaxFromMilliseconds() {
        return Instant.ofEpochMilli(Long.MAX_VALUE);
    }

    static Instant getMaxFromSeconds() {
        //напишите тут ваш код

        return Instant.ofEpochSecond(Instant.MAX.getEpochSecond());
    }

    static Instant getMaxFromSecondsAndNanos() {
        //напишите тут ваш код

        return Instant.ofEpochSecond(Instant.MAX.getEpochSecond(),999999999);
    }

    static public Instant plusMinutes(Instant instant, long minutes) {
        return instant.plusSeconds(minutes*60);
    }

    static public Instant plusHours(Instant instant, long hours) {
        return instant.plusSeconds(hours*3600);
    }

    static public Instant plusDays(Instant instant, long days) {
        return instant.plusSeconds(days*24*3600);
    }

    static public Instant minusMinutes(Instant instant, long minutes) {
        return instant.minusSeconds(minutes*60);
    }

    static public Instant minusHours(Instant instant, long hours) {
        return instant.minusSeconds(hours*3600);
    }

    static public Instant minusDays(Instant instant, long days) {
        return instant.minusSeconds(days*24*3600);
    }

    static TreeSet<String> getSortedZones() {
        TreeSet<String> s = new TreeSet<>();
        ZoneId.getAvailableZoneIds().forEach(p->
                s.add(p));
        return s;
    }

    static ZonedDateTime getBeijingDateTime() {
        ZoneId z = ZoneId.of("Asia/Shanghai");
        ZonedDateTime time = ZonedDateTime.now(z);

        return time ;
    }

    static LocalDateTime changeZone(LocalDateTime fromDateTime, ZoneId fromZone, ZoneId toZone) {
    ZonedDateTime time  = ZonedDateTime.of(fromDateTime, fromZone);
        return time.withZoneSameInstant(toZone).toLocalDateTime();
    }

    public static String example(LocalDateTime dt){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyyг. Hч.mmмин");
        return dtf.format(dt);
    }
    public static void example2(ZonedDateTime time){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("e d.M.yy HH:mm:ss.n \nVV");
        System.out.println(dtf.format(time));
    }
    public static void example3(String str){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss d/M/yyyy");
        System.out.println(LocalDateTime.parse(str, dateTimeFormatter));

    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}


