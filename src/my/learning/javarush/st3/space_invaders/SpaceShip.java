package my.learning.javarush.st3.space_invaders;

public class SpaceShip extends  BaseObject{
    private double dx;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    public void moveLeft(){
        dx=-1;
    }
    public void moveRight(){
        dx=1;
    }

    public void move(){
        x+=dx;
        checkBorders();
    }

    public boolean checkBorders(){
        if(x>=0&& x< Space.game.getWidth()){
            return true;
        }
        else{return false;}
    }
}
