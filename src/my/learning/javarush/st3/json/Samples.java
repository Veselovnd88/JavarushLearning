package my.learning.javarush.st3.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

public class Samples {

    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Vasya";
        cat.age = 5;
       // cat.weight = 5;
        Dog dog = new Dog();
        dog.name = "Lassi";
        dog.age = 10;
        dog.owner = "Papa";

        House house = new House();
        house.pets.add(dog);
        house.pets.add(cat);


        StringWriter sw = new StringWriter();
        ObjectMapper om = new ObjectMapper();

        om.writeValue(sw,house);

        String result = sw.toString();
        System.out.println(result);
        StringReader sr = new StringReader(sw.toString());
        ObjectMapper mapper = new ObjectMapper();
        House h2 = mapper.readValue(sr,House.class);
        h2.pets.forEach(x-> System.out.println(x.name));
    }
}
