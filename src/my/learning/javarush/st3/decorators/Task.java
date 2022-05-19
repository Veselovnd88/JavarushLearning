package my.learning.javarush.st3.decorators;

import my.learning.javarush.st3.decorators.decorators.RedShapeDecorator;
import my.learning.javarush.st3.decorators.shapes.Circle;
import my.learning.javarush.st3.decorators.shapes.Rectangle;
import my.learning.javarush.st3.decorators.shapes.Shape;

public class Task {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Simple circle");
        circle.draw();

        System.out.println("\nApplied RedShapeDecorator to the circle");
        redCircle.draw();

        System.out.println("\nApplied RedShapeDecorator to the rectangle");
        redRectangle.draw();
    }
}
