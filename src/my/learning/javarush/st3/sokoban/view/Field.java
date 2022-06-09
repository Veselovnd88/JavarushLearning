package my.learning.javarush.st3.sokoban.view;

import my.learning.javarush.st3.sokoban.controller.EventListener;
import my.learning.javarush.st3.sokoban.model.Box;
import my.learning.javarush.st3.sokoban.model.Home;
import my.learning.javarush.st3.sokoban.model.Wall;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
            this.view = view;
    }
    @Override
    public void paint(Graphics graphics){
        Home home = new Home(50,50);
        home.draw(graphics);
        Wall wall = new Wall(10,10);
        wall.draw(graphics);
    }
    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }






}
