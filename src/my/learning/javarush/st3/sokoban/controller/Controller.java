package my.learning.javarush.st3.sokoban.controller;

import my.learning.javarush.st3.sokoban.model.Model;
import my.learning.javarush.st3.sokoban.view.View;

public class Controller {
    private View view;
    private Model model;

    public Controller() {
        this.view = new View(this);
        this.model = new Model();
        view.init();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

    }
}
