package my.learning.javarush.st3.space_invaders;

public class SpaceShip extends  BaseObject{
    private double dx;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };

    public void moveLeft(){
        dx=-1;
    }
    public void moveRight(){
        dx=1;
    }

    public void move(){
        x+=dx;
        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() + 1);
    }


    public void draw(Canvas canvas){
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'M');

    }
    public void fire(){
        Rocket r1 = new Rocket(getX()-1,getY());
        Rocket r2 = new Rocket(getX()+1, getY());
        Space.game.getRockets().add(r1);
        Space.game.getRockets().add(r2);
    }
}
