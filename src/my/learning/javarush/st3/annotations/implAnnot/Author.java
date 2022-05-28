package my.learning.javarush.st3.annotations.implAnnot;

public @interface Author {
    String value() default "";
    Position position() default Position.OTHER;

}
