package my.learning.javarush.st3.level8;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        Color originalColor = image[y][x];

        if(originalColor==desiredColor){
            return false;
        }
        if(y>=image.length|| x>=image[0].length|| x<0||y<0){
            return false;
        }



            paintFill(image,x,y,desiredColor,originalColor);
            return true;

    }
    public void paintFill(Color[][] image, int x, int y, Color desiredColor, Color oldColor){
        if(x<0|| y<0||x>=image[0].length||y>=image.length){
            return;
        }
        if(image[y][x]==oldColor){
            image[y][x] = desiredColor;
            paintFill(image,x+1,y,desiredColor,oldColor);
            paintFill(image,x-1,y,desiredColor,oldColor);
            paintFill(image,x,y+1,desiredColor,oldColor);
            paintFill(image,x,y-1,desiredColor,oldColor);
        }
    }
}

