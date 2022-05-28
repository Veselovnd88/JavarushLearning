package my.learning.javarush.st3.annotations.implAnnot;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface Changelog {
    Revision[] value() default {};
}
