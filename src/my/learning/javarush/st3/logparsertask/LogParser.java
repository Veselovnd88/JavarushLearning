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

    private List<MyLog> logList = new ArrayList<>();
    private Path logDir;
    public LogParser(Path logDir){
        this.logDir = logDir;
    }

    public Event chooseEvent(String s){
        String[] parts = s.split(" ");
        String event = parts[0];
        if(event.equals("LOGIN")){
            return Event.LOGIN;
        }
        else if(event.equals("DOWNLOAD_PLUGIN")){
            return Event.DOWNLOAD_PLUGIN;
        }
        else if(event.equals("WRITE_MESSAGE")){
            return Event.WRITE_MESSAGE;
        }
        else if(event.equals("SOLVE_TASK")){
            return Event.SOLVE_TASK;
        }
        else if(event.equals("DONE_TASK")){
            return Event.DONE_TASK;
        }
        else{
            return null;
        }
    }
    public Status chooseStatus(String s){
        if(s.equals("OK")){
            return Status.OK;
        }
        else if(s.equals("FAILED")){
            return Status.FAILED;
        }
        else if(s.equals("ERROR")){
            return Status.ERROR;
        }
        else{return null;}
    }
    public MyLog parseLine(String line){
        String[] parts = line.split("\\t");
       // System.out.println(parts.length);
        String ip = parts[0];
        String name = parts[1];
       // System.out.println(parts[2]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(parts[2]);
         //   System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Event event = chooseEvent(parts[3]);
        //System.out.println(event);
        Status status = chooseStatus(parts[4]);
        //System.out.println(status);

        return new MyLog(ip,name,date, event,status);

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
                    MyLog l = parseLine(line);
                    if(l!=null){
                        logList.add(l);
                    }
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        int count = 0;
        for(MyLog m: logList){
            if(after==null){
                if(m.getDate().before(before) || m.getDate().equals(before)){
                    count++;
                }
            }
            else if( before==null){
                if(m.getDate().after(after)|| m.getDate().equals(after)){
                    count++;
                }
            }
            else if(before==null && after==null){
                return logList.size();
            }
            else {
                if(m.getDate().before(after)&&m.getDate().after(before)){
                    count++;
                }
            }
        }

        return count;
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
