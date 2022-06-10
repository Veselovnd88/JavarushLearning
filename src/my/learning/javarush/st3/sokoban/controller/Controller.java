package my.learning.javarush.st3.sokoban.controller;

import my.learning.javarush.st3.sokoban.model.Direction;
import my.learning.javarush.st3.sokoban.model.GameObject;
import my.learning.javarush.st3.sokoban.model.GameObjects;
import my.learning.javarush.st3.sokoban.model.Model;
import my.learning.javarush.st3.sokoban.view.View;

public class Controller implements EventListener{
    private View view;
    private Model model;

    public Controller() {
        this.view = new View(this);
        this.model = new Model();
        view.init();
        model.restart();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

    }
    public GameObjects getGameObjects(){//запрашивает игровые объекты у модели и возвращает их
        return model.getGameObjects();
    }



    @Override
    public void move(Direction direction) {

    }

    @Override
    public void restart() {

    }

    @Override
    public void startNextLevel() {

    }

    @Override
    public void levelCompleted(int level) {

    }
}
