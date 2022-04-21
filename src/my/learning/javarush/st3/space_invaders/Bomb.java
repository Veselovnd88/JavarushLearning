package my.learning.javarush.st3.space_invaders;

public class Bomb extends BaseObject{
    public Bomb(double x, double y) {
        super(x, y,1);
    }

    public void move(){
        y++;
    }
    public void draw(Canvas canvas){
        canvas.setPoint(y,x,'B');
    }

}
