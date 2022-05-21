package my.learning.javarush.st3.logparsertask;

import com.ibm.jvm.Log;
import my.learning.javarush.st3.logparsertask.query.IPQuery;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery {

    private List<Log> logList = new ArrayList<>();
    private Path logDir;
    public LogParser(Path logDir){
        this.logDir = logDir;
    }

    public Log parseLine(String line){
        String[] parts = line.split("\\t");
       // System.out.println(parts.length);
        String ip = parts[0];
        String name = parts[1];
        System.out.println(parts[2]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            Date date = sdf.parse(parts[2]);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String event = parts[3];
        String status = parts[4];


        return null;

    }
    public void parseLogs(){
        List<Path> logFiles = new ArrayList<>();
        try {
            DirectoryStream<Path> ds = Files.newDirectoryStream(this.logDir);
            for(Path p: ds){
                if(Files.isRegularFile(p) && p.getFileName().toString().endsWith(".log")){
                    //System.out.println(p.getFileName());
                    logFiles.add(p);
                }//собрали файлы с логами в один список
            }
            for(Path p: logFiles){
                BufferedReader br = new BufferedReader(new FileReader(p.toFile()));
                String line;
                while(!((line = br.readLine()) ==null)){
                    parseLine(line);
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {


        return 0;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}
