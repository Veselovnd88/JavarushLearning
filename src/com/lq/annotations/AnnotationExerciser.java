package com.lq.annotations;


import java.lang.annotation.Annotation;

public class AnnotationExerciser {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        Class[] classes = {UseAnnotations.class};
        for (Class classObj : classes){
            Annotation[]  annotations  = classObj.getAnnotations();
            System.out.println("Number of annotation is"+ annotations.length);
            for (Annotation annotation: annotations){
                MyAnnotation a = (MyAnnotation) annotation;
                System.out.println(a.name());
            }
        }
    }
}
