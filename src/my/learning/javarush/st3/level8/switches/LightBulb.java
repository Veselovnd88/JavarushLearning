package my.learning.javarush.st3.level8.switches;

public class LightBulb implements Switchable {
    private boolean on = false;

    public boolean isOn() {
        return on;
    }

   public void turnOff() {
        System.out.println("The light is off!");
        on = false;
    }

    public void turnOn() {
        System.out.println("The light is on!");
        on = true;
    }
}
