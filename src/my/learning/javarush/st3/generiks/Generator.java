package my.learning.javarush.st3.generiks;

public class Generator<T> {
    Class<T> clazz;
    public Generator(Class clazz){
        this.clazz = clazz;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {

        return clazz.newInstance();
    }
}
