package my.learning.javarush.st3.tetris;

public class Figure {

    private int x;
    private int y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix){
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }
    public void left(){

    }
    public void right(){

    }
    public void down(){

    }
    public void up(){

    }
    public void rotate(){

    }
    public void downMaximum(){

    }
    boolean isCurrentPositionAvailable(){
        return true;
    }
    public void landed(){

    }




    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }
}
