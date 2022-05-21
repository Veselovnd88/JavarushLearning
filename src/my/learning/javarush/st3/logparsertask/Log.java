package my.learning.javarush.st3.logparsertask;

import java.util.Date;

public class Log {
    private String ip;
    private String userName;
    private Date date;
    private Event event;
    private Status status;

    public Log(String ip, String userName, Date date, Event event, Status status) {
        this.ip = ip;
        this.userName = userName;
        this.date = date;
        this.event = event;
        this.status = status;
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
}
