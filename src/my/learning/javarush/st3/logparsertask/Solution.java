package my.learning.javarush.st3.logparsertask;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse("11.12.2013 10:11:12");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        LogParser logParser = new LogParser(Paths.get("src/my/learning/javarush/st3/logparsertask/logs"));
        //logParser.parseLogs();
        System.out.println(logParser.getNumberOfUniqueIPs(new Date(), null));
        System.out.println(logParser.getUniqueIPs(null, null));
        System.out.println(logParser.getIPsForUser("Vasya Pupkin", null,new Date()));
        System.out.println(logParser.getIPsForEvent(Event.LOGIN,null, new Date()));

    }
}
