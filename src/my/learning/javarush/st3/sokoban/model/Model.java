package my.learning.javarush.st3.sokoban.model;

import my.learning.javarush.st3.sokoban.controller.Controller;
import my.learning.javarush.st3.sokoban.controller.EventListener;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Model {
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel=1;
    private LevelLoader levelLoader;

    public static final int FIELD_CELL_SIZE = 20;

    public Model() {
        try {
            levelLoader = new LevelLoader(Paths.get(getClass().getResource("../res/levels.txt").toURI()));
        } catch (URISyntaxException e) {
        }
    }
    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }
    public GameObjects getGameObjects(){
        return gameObjects;
    }
    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }
    public void restart(){
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        currentLevel++;
        restartLevel(currentLevel);
    }
    public boolean checkWallCollision(CollisionObject collisionObject, Direction direction){
        for (Wall wall: getGameObjects().walls){
            if(collisionObject.isCollision(wall,direction)){
                return true;
            }
        }
        return false;
    }

    public void move(){

    }







}
