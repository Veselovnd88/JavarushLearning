package my.learning.javarush.st3.sokoban.view;

import my.learning.javarush.st3.sokoban.model.Box;
import my.learning.javarush.st3.sokoban.model.Home;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private View view;


    public Field(View view) {
            this.view = view;
    }
    @Override
    public void paint(Graphics graphics){
        Home home = new Home(10,10);
        home.draw(graphics);
    }




}
