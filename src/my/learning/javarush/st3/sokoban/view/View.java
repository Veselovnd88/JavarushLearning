package my.learning.javarush.st3.sokoban.view;

import my.learning.javarush.st3.sokoban.controller.Controller;
import my.learning.javarush.st3.sokoban.controller.EventListener;
import my.learning.javarush.st3.sokoban.model.GameObjects;


import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }
    public void update(){
        field.repaint();// метод апдейт вызывает репэит у филд - обновление представления - перерисовка поля
    }


    public GameObjects getObjects(){
       return controller.getGameObjects();//класс представления получает игровые объекты у контроллера
    }


    public void setEventListener(EventListener eventListener){
        field.setEventListener(eventListener);
    }
    public void completed(int level){
        this.update();
        JOptionPane.showMessageDialog(this, "Уровень " + level + " пройден.", "Вы выиграли", JOptionPane.INFORMATION_MESSAGE);
        controller.startNextLevel();

    }
}
