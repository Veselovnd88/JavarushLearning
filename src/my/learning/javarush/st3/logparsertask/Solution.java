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
            date = sdf.parse("03.01.2014 03:45:23");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        LogParser logParser = new LogParser(Paths.get("src/my/learning/javarush/st3/logparsertask/logs"));
        //logParser.parseLogs();
       // System.out.println(logParser.getNumberOfUniqueIPs(new Date(), null));
        //System.out.println(logParser.getUniqueIPs(null, null));
        //System.out.println(logParser.getIPsForUser("Vasya Pupkin", null,new Date()));
        //System.out.println(logParser.getIPsForEvent(Event.LOGIN,null, new Date()));
        //System.out.println(logParser.getAllUsers());
        //System.out.println(logParser.getNumberOfUserEvents("Vasya Pupkin",null,null));
        //System.out.println(logParser.getUsersForIP("120.120.120.122", null, null));
        //System.out.println(logParser.getLoggedUsers(null, null));
       // System.out.println(logParser.getSolvedTaskUsers(null,null,-1));
       // System.out.println(logParser.getDateWhenUserLoggedFirstTime("Vasya Pupkin",new Date(),new Date()));
       // System.out.println(logParser.getFailedEvents(null,null));
      //  System.out.println(logParser.getNumberOfAttemptToSolveTask(18,null,null));
       // System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null,null));
      //  System.out.println(logParser.getEventsForUser("Vasya Pupkin", null, null));
       // System.out.println(logParser.execute("get date"));
      //  System.out.println(logParser.execute("get ip for date = \"03.01.2014 03:45:23\""));
        //System.out.println(logParser.execute("get event for status = \"OK\""));
       //System.out.println(logParser.execute("get event for date = \"03.01.2014 03:45:23\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\""));

        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 10:11:11\" and \"03.01.2014 23:59:59\""));

        System.out.println(logParser.execute("get date for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 10:11:11\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for date = \"13.09.2013 5:04:50\" and date between \"11.12.2013 10:11:11\" and \"03.01.2014 23:59:59\""));

    }
}
