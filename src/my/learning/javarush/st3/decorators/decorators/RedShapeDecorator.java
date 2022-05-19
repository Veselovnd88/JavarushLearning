package my.learning.javarush.st3.decorators.decorators;

import my.learning.javarush.st3.decorators.decorators.ShapeDecorator;
import my.learning.javarush.st3.decorators.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {


    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    private void setBorderColor(Shape shape){
        System.out.println("Setting the border color for "+shape.getClass().getSimpleName()+" to red");
    }

    @Override
    public void draw() {
        setBorderColor(super.decoratedShape);
        super.decoratedShape.draw();
    }
}
