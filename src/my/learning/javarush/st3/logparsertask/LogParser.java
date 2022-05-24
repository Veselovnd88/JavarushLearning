package my.learning.javarush.st3.logparsertask;

import com.ibm.jvm.Log;
import my.learning.javarush.st2.BooksTask;
import my.learning.javarush.st3.logparsertask.query.IPQuery;
import my.learning.javarush.st3.logparsertask.query.UserQuery;

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

public class LogParser implements IPQuery, UserQuery {
    private HashMap<String, List<MyLog>> ipLog = new HashMap<>();
    private HashMap<Date,List<MyLog>> dateLog = new HashMap<>();
    private List<MyLog> logList = new ArrayList<>();
    private Path logDir;
    public LogParser(Path logDir){
        this.logDir = logDir;
        parseLogs();
        fillDateMap();
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
        Task task = null;
        String[] parts = line.split("\\t");
       // System.out.println(parts.length);
        String ip = parts[0];
        String name = parts[1];
       // System.out.println(parts[2]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(parts[2]);
         //   Systema.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Event event = chooseEvent(parts[3]);
        if(event == Event.SOLVE_TASK || event ==Event.DONE_TASK){
            task = new Task(event, Integer.parseInt(parts[3].split(" ")[1]));
        }
        //System.out.println(event);
        Status status = chooseStatus(parts[4]);
        System.out.println(status);

        return new MyLog(ip,name,date, event,status,null);

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

    public void fillIpMap(){
        for(MyLog m: logList){
            if(ipLog.get(m.getIp())==null){
                List<MyLog> l = new ArrayList<>();
                l.add(m);
                ipLog.put(m.getIp(),l);
            }
            else{
                List<MyLog> l = ipLog.get(m.getIp());
                l.add(m);
                ipLog.put(m.getIp(),l);
            }
        }
    }

    public void fillDateMap(){
        for(MyLog m: logList){
            if(dateLog.get(m.getDate())==null){
                List<MyLog> l = new ArrayList<>();
                l.add(m);
                dateLog.put(m.getDate(),l);
            }
            else{
                List<MyLog> l = dateLog.get(m.getDate());
                l.add(m);
                dateLog.put(m.getDate(),l);
            }
        }
    }
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after,before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        if(dateLog.size()==0){
            fillDateMap();
        }
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
                    for(MyLog m: entry.getValue()){
                        ipSet.add(m.getIp());
                    }
                }
        return ipSet;
    }
    public HashMap<Date, List<MyLog>> filterLogs(Date after, Date before){
        HashMap<Date, List<MyLog>> filteredMap = new HashMap<>();
        if (dateLog.size()==0){
            fillDateMap();
        }
        for(Map.Entry<Date, List<MyLog>> entry: dateLog.entrySet()){
            if(after==null&&before!=null){
                if(entry.getKey().before(before) || entry.getKey().equals(before)){
                    filteredMap.put(entry.getKey(), entry.getValue());
                }
            }
            else if(before==null&&after!=null){
                //   System.out.println("Зашел");
                if(entry.getKey().after(after)|| entry.getKey().equals(after)){
                    filteredMap.put(entry.getKey(),entry.getValue());
                }}
            else if(before==null && after==null){
               filteredMap.put(entry.getKey(),entry.getValue());
            }
            else  {
                if(entry.getKey().before(before)&&entry.getKey().after(after)){
                    filteredMap.put(entry.getKey(),entry.getValue());
                }
            }
        }
        return filteredMap;
    }
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        HashSet<String> ipsForUser = new HashSet<>();
        if(dateLog.size()==0){
            fillDateMap();
        }
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
            for(MyLog m:entry.getValue()){
                if(m.getUserName().equals(user)){
                    ipsForUser.add(m.getIp());
                }
            }
        }
        return ipsForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        HashSet<String> ipsForEvent = new HashSet<>();
        if(dateLog.size()==0){
            fillDateMap();
        }
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(m.getEvent()==event){
                    ipsForEvent.add(m.getIp());
                }
            }
        }
        return ipsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        HashSet<String> ipsForStatus = new HashSet<>();
        if(dateLog.size()==0){
            fillDateMap();
        }
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(m.getStatus()==status){
                    ipsForStatus.add(m.getIp());
                }
            }
        }
        return ipsForStatus;
    }


    @Override
    public Set<String> getAllUsers() {
        HashSet<String> users = new HashSet<>();
        for(Map.Entry<Date, List<MyLog>> entry: dateLog.entrySet()){
            for(MyLog m: entry.getValue()){
                users.add(m.getUserName());
            }
        }
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {

        HashSet<String> users = new HashSet<>();
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
            for(MyLog m: entry.getValue()){
                users.add(m.getUserName());
            }
        }
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        HashSet<Event> events = new HashSet<>();
        for(Map.Entry<Date,List<MyLog>> entry:filterLogs(after,before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(user.equals(m.getUserName())){
                    events.add(m.getEvent());
                }
            }
        }
        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        HashSet<String> users = new HashSet<>();
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(ip.equals(m.getIp())){
                    users.add(m.getUserName());
                }
            }
        }
        return users;
    }
    public Set<String> getUserWithStatus(Event event, Date after, Date before, Status status){

        HashSet<String> users = new HashSet<>();
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(status==null){
                    if(m.getEvent() == event){
                        users.add(m.getUserName());
                }
                }
                else{
                    if(m.getEvent()==event && m.getStatus()==status){
                        users.add(m.getUserName());
                    }
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUserWithStatus(Event.LOGIN, after,before,null);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUserWithStatus(Event.DOWNLOAD_PLUGIN, after,before,Status.OK);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUserWithStatus(Event.WRITE_MESSAGE, after,before, Status.OK);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUserWithStatus(Event.SOLVE_TASK, after,before,null);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return null;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return null;
    }
}
