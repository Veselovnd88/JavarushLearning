package my.learning.javarush.st3.tetris;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        for(int i = 0; i<height;i++){
            for(int j=0; j<width;j++){
                if(matrix[i][j]==0){
                    System.out.print(".");
                }
                else{
                    System.out.print("X");                }
            }
            System.out.println();
        }

    }
    public void removeFullLines(){
        List<int[]> normalLines = new LinkedList<>();

        for(int i=height-1; i>=0; i--){
            if (Arrays.stream(matrix[i]).allMatch(x-> x!=0)|| Arrays.stream(matrix[i]).allMatch(x-> x==0) ){
                //System.out.println(Arrays.toString(matrix[i]));
                //System.out.println("С нулями или единицами");
                matrix[i] = null;
            }
            else{
                normalLines.add(matrix[i]);

            }
        }
        for(int j = height-1; j>=0;j--){
            if(height-1-j<normalLines.size()){
                /* лист 2, высота 3
                если дж=2 - лист ноль
                если дж = 1 - лист 1
                дж= 0 - всё
                 *
                 */

                matrix[j] = normalLines.get(height-1-j);
            }
            else{
                matrix[j] = new int[width];
            }
        }
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
    public void setMatrix(int[][] m){
        this.matrix = m;
    }
}
