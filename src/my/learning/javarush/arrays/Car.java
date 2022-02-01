package my.learning.javarush.arrays;

public class Car {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;}

    @Override
    public int hashCode() {
        return this.year+model.hashCode();
    }
}
