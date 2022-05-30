package my.learning.javarush.st3.agreggator.model;

import my.learning.javarush.st3.agreggator.vo.Vacancy;

import java.util.List;

public interface Strategy {
    List<Vacancy> getVacancies(String searchString);


}
