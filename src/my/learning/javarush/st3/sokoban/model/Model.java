package my.learning.javarush.st3.sokoban.model;

import my.learning.javarush.st3.sokoban.controller.EventListener;

public class Model {
    private EventListener eventListener;
    public static final int FIELD_CELL_SIZE = 20;

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

}
