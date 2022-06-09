package my.learning.javarush.st3.sokoban.model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {
    Set<Wall> walls;
    Set<Box> boxes;
    Set<Home> homes;
    Player player;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }
    public Set<GameObject> getAll(){
        Set<GameObject> all = new HashSet<>();
        all.addAll(boxes);
        all.addAll(walls);
        all.addAll(homes);
        all.add(player);
        return all;
    }


    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public Player getPlayer() {
        return player;
    }
}
