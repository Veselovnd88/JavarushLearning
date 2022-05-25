package my.learning.javarush.st3.logparsertask;

import my.learning.javarush.st3.logparsertask.query.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private HashMap<String, List<MyLog>> ipLog = new HashMap<>();
    private final HashMap<Date,List<MyLog>> dateLog = new HashMap<>();
    private List<MyLog> logList = new ArrayList<>();
    private final Path logDir;
    public LogParser(Path logDir){
        this.logDir = logDir;
        parseLogs();
        fillDateMap();
    }

    public Event chooseEvent(String s){
        String[] parts = s.split(" ");
        String event = parts[0];
        return switch (event) {
            case "LOGIN" -> Event.LOGIN;
            case "DOWNLOAD_PLUGIN" -> Event.DOWNLOAD_PLUGIN;
            case "WRITE_MESSAGE" -> Event.WRITE_MESSAGE;
            case "SOLVE_TASK" -> Event.SOLVE_TASK;
            case "DONE_TASK" -> Event.DONE_TASK;
            default -> null;
        };
    }
    public Status chooseStatus(String s){
        return switch (s) {
            case "OK" -> Status.OK;
            case "FAILED" -> Status.FAILED;
            case "ERROR" -> Status.ERROR;
            default -> null;
        };
    }
    public MyLog parseLine(String line){
        int task_num = 0;
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
        if(event == Event.SOLVE_TASK || event ==Event.DONE_TASK){
            task_num =  Integer.parseInt(parts[3].split(" ")[1]);
        }
        //System.out.println(event);
        Status status = chooseStatus(parts[4]);
        System.out.println(status);

        return new MyLog(ip,name,date, event,status,task_num);

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
            else if(before == null){
               filteredMap.put(entry.getKey(),entry.getValue());
            }
            else  {
                if((entry.getKey().before(before)||entry.getKey().equals(before))&& (entry.getKey().after(after)||entry.getKey().equals(after))){
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
    private Set<String> getUserWithStatus(Event event, Date after, Date before, Status status, int task){

        HashSet<String> users = new HashSet<>();
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(status==null&& task==-1){
                    if(m.getEvent() == event){
                        users.add(m.getUserName());
                }
                }
                else if (task==-1 && event!=null){
                    if(m.getEvent()==event && m.getStatus()==status){
                        users.add(m.getUserName());
                    }
                }
                else if(event == null){
                    if(m.getStatus().equals(status)){
                        users.add(m.getUserName());
                    }
                }
                else {
                    if(m.getEvent()==event){
                        if(m.getTask_num()==task){
                            users.add(m.getUserName());
                        }
                    }
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUserWithStatus(Event.LOGIN, after,before,null,-1);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUserWithStatus(Event.DOWNLOAD_PLUGIN, after,before,Status.OK,-1);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUserWithStatus(Event.WRITE_MESSAGE, after,before, Status.OK,-1);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUserWithStatus(Event.SOLVE_TASK, after,before,null,-1);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getUserWithStatus(Event.SOLVE_TASK,after,before,null,task);

    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUserWithStatus(Event.DONE_TASK,after,before,null,-1);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getUserWithStatus(Event.DONE_TASK,after,before,null,task);
    }



    private Set<Date> getDatesMethod(String user, Event event,int task, Date after,Date before,Status status){
        HashSet<Date> datesSet = new HashSet<>();
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(user!=null && event!=null &&status==null){
                    if(task==-1){
                        if(m.getUserName().equals(user)&& event.equals(m.getEvent())){
                            datesSet.add(entry.getKey());
                    }}
                    else {
                        if(m.getUserName().equals(user)&&event.equals(m.getEvent())&&m.getTask_num()==task){
                            datesSet.add(entry.getKey());
                        }
                    }
                }
                else if(user==null&& event==null&&status!=null){
                    if(m.getStatus().equals(status)){
                        datesSet.add(entry.getKey());
                    }
                }
                else if(user!=null && event==null &&status==null){
                    if(m.getUserName().equals(user)){
                        datesSet.add(entry.getKey());
                    }
                }
                else if(user==null &&event!=null &&status==null){
                    if(m.getEvent().equals(event)){
                        datesSet.add(entry.getKey());
                    }
                }

            }
        }
        return datesSet;
    }
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getDatesMethod(user,event,-1,after,before,null);
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getDatesMethod(null,null,-1,after,before,Status.FAILED);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getDatesMethod(null,null,-1,after,before,Status.ERROR);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        List<Date> dates = new ArrayList<>();
        dates.addAll(getDatesMethod(user, Event.LOGIN, -1, after, before, null));
        if(dates.size()==0){
            return null;
        }
        return //dates.stream().sorted().toList().get(0);
                dates.stream().sorted().collect(Collectors.toList()).get(0);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<Date> dates = new ArrayList<>();
        dates.addAll(getDatesMethod(user, Event.SOLVE_TASK, task, after, before, null));
        if (dates.size()==0){
            return null;
        }
        else{
           return  //dates.stream().sorted().collect(Collectors.toList()).get(0);
                   dates.stream().sorted().collect(Collectors.toList()).get(0);
        }
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<Date> dates = new ArrayList<>();
        dates.addAll(getDatesMethod(user, Event.DONE_TASK, task, after, before, null));
        if (dates.size()==0){
            return null;
        }
        else{
            return  dates.stream().sorted().collect(Collectors.toList()).get(0);
        }
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {

        return  getDatesMethod(user,Event.WRITE_MESSAGE,-1,after,before,null);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return  getDatesMethod(user,Event.DOWNLOAD_PLUGIN,-1,after,before,null);
    }


    private Set<Event> getEventMethod(String user,String ip, Event event,int task, Date after,Date before,Status status){
        Set<Event> eventSet = new HashSet<>();
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after, before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(user==null && event ==null && task==-1 && status==null && ip==null){
                    eventSet.add(m.getEvent());
                }
                else if(user==null && event==null && task==-1 &&status ==null){
                    if(m.getIp().equals(ip)){
                        eventSet.add(m.getEvent());
                    }
                }
                else if(user!=null&& ip==null && event==null && task==-1 &&status ==null){
                    if(m.getUserName().equals(user)){
                        eventSet.add(m.getEvent());
                    }
                }
                else if(user == null && event == null && task == -1){
                    if(m.getStatus().equals(status)){
                        eventSet.add(m.getEvent());
                    }
                }
                else if(user==null &&event!=null &&task!=-1 &&status==null){
                    if(m.getEvent().equals(event)&& m.getTask_num()==task){
                        eventSet.add(m.getEvent());
                    }
                }


            }
        }
        return eventSet;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getEventMethod(null,null,null,-1,after,before,null).size();

    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {

        return getEventMethod(null,null,null,-1,after,before,null);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getEventMethod(null, ip, null,-1,after,before,null);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getEventMethod(user,null,null,-1,after,before,null);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getEventMethod(null,null,null,-1,after,before,Status.FAILED);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getEventMethod(null,null,null,-1,after,before,Status.ERROR);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after,before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(m.getEvent().equals(Event.SOLVE_TASK)&& m.getTask_num()==task){
                    count++;
                }
            }
        }return  count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after,before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(m.getEvent().equals(Event.DONE_TASK)&& m.getTask_num()==task){
                    count++;
                }
            }
        }return  count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer,Integer> task_qnt = new HashMap<>();
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after,before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(m.getEvent().equals(Event.SOLVE_TASK)){

                if(task_qnt.containsKey(m.getTask_num())){
                    int count = task_qnt.get(m.getTask_num());
                    count++;
                    task_qnt.put(m.getTask_num(), count);
                }
                else{
                    task_qnt.put(m.getTask_num(),1);
                }
            }}}
        return task_qnt;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer,Integer> task_qnt = new HashMap<>();
        for(Map.Entry<Date, List<MyLog>> entry: filterLogs(after,before).entrySet()){
            for(MyLog m: entry.getValue()){
                if(m.getEvent().equals(Event.DONE_TASK)){

                    if(task_qnt.containsKey(m.getTask_num())){
                        int count = task_qnt.get(m.getTask_num());
                        count++;
                        task_qnt.put(m.getTask_num(), count);
                    }
                    else{
                        task_qnt.put(m.getTask_num(),1);
                    }
                }}}
        return task_qnt;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<? extends Object> mySet = new HashSet<>();
        String[] parts = query.split(" ");
        String f_query = parts[0]+" "+parts[1];
        String field;
        switch (f_query){
            case ("get ip") :
                if(parts.length==2){

                mySet = getUniqueIPs(null,null);}
                else {
                    field = query.substring(query.indexOf("\"")).replace("\"","");
                    System.out.println(field);
                    switch(parts[3]){
                        case ("user"): {
                        //String user = query.substring(query.indexOf("\"")).replace("\"","");
                        //System.out.println(field);
                        mySet = getIPsForUser(field,null,null);
                        break;
                    }
                        case ("date") :{
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                            Date date;
                            try {
                                date = sdf.parse(field);
                                System.out.println(date);
                                mySet = getUniqueIPs(date,date);
                                //   System.out.println(date);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case ("event"):{
                            mySet = getIPsForEvent(chooseEvent(field),null,null);
                            break;
                        }
                        case("status"):{
                            mySet = getIPsForStatus(chooseStatus(field),null,null);
                            break;
                        }
                    }
                }
            break;
            case ("get user"):
                if(parts.length==2){
                mySet = getAllUsers();}
                else {
                    field = query.substring(query.indexOf("\"")).replace("\"","");
                    System.out.println(field);
                    switch(parts[3]){
                        case ("ip"): {
                            //String user = query.substring(query.indexOf("\"")).replace("\"","");
                            //System.out.println(field);
                            mySet = getUsersForIP(field,null,null);
                            break;
                        }
                        case ("date") :{
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                            Date date;
                            try {
                                date = sdf.parse(field);
                                //System.out.println(date);
                                Set<String> s = new HashSet<>();
                                for(Map.Entry<Date, List<MyLog>> entry: filterLogs(date,date).entrySet()){
                                    if(entry.getKey().equals(date)){
                                        for(MyLog m: entry.getValue()){
                                            s.add(m.getUserName());
                                        }
                                    }
                                }mySet=s;
                                //   System.out.println(date);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case ("event"):{
                            mySet = getUserWithStatus(chooseEvent(field),null,null,null,-1);
                            break;
                        }
                        case("status"):{
                            mySet = getUserWithStatus(null,null,null,chooseStatus(field),-1);
                            break;
                        }
                    }
                }
            break;
            case ("get date"):
                if(f_query.length()==2){
                mySet = dateLog.keySet();}
                else {
                    field = query.substring(query.indexOf("\"")).replace("\"","");
                    //System.out.println(field);
                    switch(parts[3]){
                        case ("ip"): {
                            //String user = query.substring(query.indexOf("\"")).replace("\"","");
                            //System.out.println(field);
                            Set<Date> s = new HashSet<>();
                            for(Map.Entry<Date,List<MyLog>> entry: dateLog.entrySet()){
                                for(MyLog m: entry.getValue()){
                                    if(m.getIp().equals(field)){
                                        s.add(entry.getKey());
                                    }
                                }
                            } mySet=s;
                            break;
                        }
                        case ("user") :{
                            mySet = getDatesForUserAndEvent(field,null,null,null);
                            break;
                        }
                        case ("event"):{
                            mySet = getDatesMethod(null,chooseEvent(field),-1,null,null,null);
                            break;
                        }
                        case("status"):{
                            mySet = getDatesMethod(null,null,-1,null,null,chooseStatus(field));
                            break;
                        }
                    }
                }
            break;
            case ("get event"): mySet = getAllEvents(null,null); break;
            case ("get status"):{
                Set<Status> s = new HashSet<>();
                for(Map.Entry<Date, List<MyLog>> entry: dateLog.entrySet()){
                    for(MyLog m: entry.getValue()){
                        s.add(m.getStatus());
                    }
                } mySet = s; break;
            }
        }

        return (Set<Object>) mySet;
    }
}
