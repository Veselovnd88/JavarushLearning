package my.learning.javarush.st3.space_invaders;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height){
        this.width = width;
        this.height = height;
        matrix = new char[height][width];
    }
    public void setPoint(double x, double y, char c){
        int x_coord = (int) Math.round(x);
        int y_coord = (int) Math.round(y);
        if(x>=0 && x< matrix[0].length && y>=0&& y<matrix.length){
            matrix[y_coord][x_coord] = c;
        }

    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        int x_coord = (int) Math.round(x);
        int y_coord = (int) Math.round(y);
        for (int i=0; i<matrix.length;i++){
            for(int j = 0; j< matrix[i].length; j++){
                if(matrix[i][j]!=0){
                    setPoint(x+j, y+i, c);
                }
            }
        }
    }
    public void clear(){
        for(int i = 0; i< matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                matrix[i][j] = ' ';
            }
        }
    }
    public void print(){
        for(int i = 0; i< matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}
