package my.learning.javarush.st3.json.tasks;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

public class serializ {

    public static void task() throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        StringWriter writer = new StringWriter();
        convertToJSON(writer, cat);
        System.out.println(convertFromJsonToNormal(writer.toString(),Cat.class).getClass());


    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }
    @JsonAutoDetect
    public static class Pet {

        public String name;
    }
    @JsonAutoDetect
    public static class Cat extends Pet {

        public int age;

        public int weight;
    }
    @JsonAutoDetect// сам определяет что сериализовать, все поля долджны быть паблик
    public static class Dog extends Pet {

        public int age;

        public String owner;
    }


    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper om = new ObjectMapper();
        FileReader fr = new FileReader(fileName);
        T obj = om.readValue(fr, clazz);
        return obj;
    }
}
