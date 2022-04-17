package my.learning.javarush.st3.json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import my.learning.javarush.st2.AdaptersTask;


import java.util.ArrayList;
import java.util.List;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
@JsonSubTypes.Type(value = Cat.class, name = "cat"),
@JsonSubTypes.Type(value = Dog.class, name = "dog")})
public class Pet {
    public String name;



}

class Dog extends  Pet{
    public int age;
    public String owner;
}

class Cat extends Pet{
    public int age;
}

class House{
    public List<Pet> pets = new ArrayList<>();

}

