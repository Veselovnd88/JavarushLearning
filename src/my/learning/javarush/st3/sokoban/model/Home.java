package my.learning.javarush.st3.sokoban.model;

import java.awt.*;

public class Home extends GameObject {

    private static final int HOME_DIM = 2;

    public Home(int x, int y) {
        super(x, y,HOME_DIM,HOME_DIM);
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        int xc = getX();
        int yc = getY();

        graphics.drawOval(xc - width / 2, yc - height / 2, width, height);
        graphics.drawRect(xc - width / 2, yc - height / 2, width, height);
    }
}
