package my.learning.javarush.st3.decorators.shapes;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a shape: RECTANGLE!");
    }
}