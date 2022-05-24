package my.learning.javarush.st3.logparsertask;

public class Task {

    private Event task_status;
    private int num;


    public Task(Event task_status, int num) {
        this.task_status = task_status;
        this.num = num;
    }

    public void setTask_status(Event task_status) {
        this.task_status = task_status;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
