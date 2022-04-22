package my.learning.javarush.st3.space_invaders;

public class Rocket extends  BaseObject{
    public Rocket(double x, double y) {
        super(x, y, 1);
    }
    public void move(){
        y--;
    }
    public void draw(Canvas canvas){
        canvas.setPoint(y,x,'R');
    }
}
