package my.learning.javarush.st3.sokoban.controller;

import my.learning.javarush.st3.sokoban.model.Direction;
import my.learning.javarush.st3.sokoban.model.GameObject;
import my.learning.javarush.st3.sokoban.model.GameObjects;
import my.learning.javarush.st3.sokoban.model.Model;
import my.learning.javarush.st3.sokoban.view.View;

import javax.swing.*;

public class Controller implements EventListener{
    private View view;
    private Model model;

    public Controller() {
        this.view = new View(this);
        this.model = new Model();
        view.init();//отрисовка поля
        model.restart();//рестарт игры с текущим левелом в конструкторе
        view.setEventListener(this);//установка слушателя - слушатель будет сам контроллер (имплементирует этот интерфейс)
        model.setEventListener(this);// на вью и на модель
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

    }
    public GameObjects getGameObjects(){//запрашивает игровые объекты у модели и возвращает их
        return model.getGameObjects();
    }



    @Override
    public void move(Direction direction) {
        model.move(direction);//двигает объект и обновляет вью
        view.update();
    }

    @Override
    public void restart() {
        model.restart();//перезапускает модель и обновляет вью
        view.update();

    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();//запускает у модели новый уровень и обновляет вью
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }
}
