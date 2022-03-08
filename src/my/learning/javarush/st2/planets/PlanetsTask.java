package my.learning.javarush.st2.planets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanetsTask {
    public static void task() {

    }

    public static Planet thePlanet;
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        try {BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.equals(Planet.EARTH)){
            thePlanet = Earth.getInstance();}
        else if (str.equals(Planet.MOON)) {
                thePlanet = Moon.getInstance();
            }
        else if(str.equals(Planet.SUN)){
            thePlanet = Sun.getInstance();
        }
        else {thePlanet = null;}
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
