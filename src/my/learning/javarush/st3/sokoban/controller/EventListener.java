package my.learning.javarush.st3.sokoban.controller;

import my.learning.javarush.st3.sokoban.model.Direction;

public interface EventListener {
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);

}
