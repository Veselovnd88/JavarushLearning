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
        for (Wall wall: getGameObjects().getWalls()){// для каждой стены проверяю столкновение
            if(collisionObject.isCollision(wall,direction)){
                return true;
            }
        }
        return false;
    }


    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction){
        for (Box box: getGameObjects().getBoxes()){//для каждого ящика
            if(getGameObjects().getPlayer().isCollision(box,direction)){//если игрок сталкивается с ящиком
                for(Box bx: getGameObjects().getBoxes()){//для каждого ящика проверяем условие
                    if(!box.equals(bx)){//если это не ящик из предыдущей итерации
                        if(box.isCollision(bx,direction)){//если пересеклись то тру
                            return true;
                            /*проверяем если игрок сталвикается с ящиком - то проверяем, сталкивается ли ящик еще  с ящиком - если да- то тру
                            * */
                        }
                    }
                    if(checkWallCollision(box,direction)){//та же самая история со стенами
                        return true;
                    }
                }
                int dx = direction == Direction.LEFT ? -FIELD_CELL_SIZE : (direction == Direction.RIGHT ? FIELD_CELL_SIZE : 0);
                //если направление-лево, то дИкс - 20, если право-то 20, если ни то ни другое 0
                int dy = direction == Direction.UP ? -FIELD_CELL_SIZE : (direction == Direction.DOWN ? FIELD_CELL_SIZE : 0);
                //то же самое для y
                box.move(dx, dy);
            }
        }
        return false;
    }
    public void checkCompletion(){
        int numHomes = getGameObjects().getHomes().size();
        int homesWBoxes = 0;

        for(Home home: getGameObjects().getHomes()){
            for (Box box :getGameObjects().getBoxes()){
                if(home.getX()==box.getX()&&home.getY()==box.getY()){
                    homesWBoxes++;
                }
            }
        }
        //проверка равенства координат домов и коробок
        if(numHomes==homesWBoxes){
            eventListener.levelCompleted(currentLevel);
        }
    }


    public void move(Direction direction){
        if(checkWallCollision(getGameObjects().getPlayer(),direction)){
            return;
        }
        if (checkBoxCollisionAndMoveIfAvailable(direction)) {
            return;
        }
        int dx = direction == Direction.LEFT ? -FIELD_CELL_SIZE : (direction == Direction.RIGHT ? FIELD_CELL_SIZE : 0);
        int dy = direction == Direction.UP ? -FIELD_CELL_SIZE : (direction == Direction.DOWN ? FIELD_CELL_SIZE : 0);
        gameObjects.getPlayer().move(dx, dy);

        checkCompletion();

    }







}
