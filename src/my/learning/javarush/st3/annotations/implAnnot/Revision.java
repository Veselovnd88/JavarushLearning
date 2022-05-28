package my.learning.javarush.st3.annotations.implAnnot;

public @interface Revision {
    int revision();
    Date date();
    Author[] authors() default {};
    String comment() default "";

}
