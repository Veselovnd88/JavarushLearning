package my.learning.javarush.st3.json.tasks;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "className")



public abstract class Vehicle {
   // @JsonProperty("name")
    protected String name;
    //@JsonProperty("owner")
    protected String owner;
//
    protected int age;
}
