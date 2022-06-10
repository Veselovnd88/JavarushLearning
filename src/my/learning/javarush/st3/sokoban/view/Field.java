package my.learning.javarush.st3.sokoban.view;

import my.learning.javarush.st3.sokoban.controller.EventListener;
import my.learning.javarush.st3.sokoban.model.*;
import my.learning.javarush.st3.sokoban.model.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
            this.view = view;
            addKeyListener(new KeyHandler());
            setFocusable(true);

    }
    @Override
    public void paint(Graphics graphics){
        //залить всё поле цветом
        graphics.setColor(Color.black);
        graphics.fillRect(0,0,getWidth(),getHeight());//красит поле черным цветом
        GameObjects gameObjects = view.getObjects();//получили объект игровыъ объектов из метод представления
        for(GameObject go: gameObjects.getAll()){
            go.draw(graphics);// нарисовали все объекты
        }
    }
    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }
   public class KeyHandler extends KeyAdapter{

       @Override
       public void keyPressed(KeyEvent e) {
           if(e.getKeyCode()==KeyEvent.VK_LEFT){
               eventListener.move(Direction.LEFT);
           }
           else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
               eventListener.move(Direction.RIGHT);
           }
           else if (e.getKeyCode()==KeyEvent.VK_UP){
               eventListener.move(Direction.UP);
           }
           else if(e.getKeyCode()==KeyEvent.VK_DOWN){
               eventListener.move(Direction.UP);
           }
           else if(e.getKeyCode()==KeyEvent.VK_R){
               eventListener.restart();
           }
       }
   }



}


