package my.learning.javarush.st3.tetris;

public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height){
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }
    public void print(){

    }
    public void removeFullLines(){

    }
    public Integer getValue(int x, int y){
        return null;
    }
    public void setValue(int x, int y, int value){

    }



    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }
}
