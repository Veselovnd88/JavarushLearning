package my.learning.javarush.st3.logparsertask;

import java.util.Date;

public class MyLog {
    private String ip;
    private String userName;
    private Date date;
    private Event event;
    private Status status;
    private Task task;

    public MyLog(String ip, String userName, Date date, Event event,  Status status,Task task) {
        this.ip = ip;
        this.userName = userName;
        this.date = date;
        this.event = event;
        this.status = status;
        this.task = task;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public String getUserName() {
        return userName;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public Status getStatus() {
        return status;
    }

    public Task getTask() {
        return task;
    }
}
