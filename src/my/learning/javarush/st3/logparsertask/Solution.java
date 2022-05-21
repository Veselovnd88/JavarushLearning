package my.learning.javarush.st3.logparsertask;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("src/my/learning/javarush/st3/logparsertask/logs"));
        //logParser.parseLogs();
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));

    }
}
