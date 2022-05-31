package my.learning.javarush.st3.agreggator.view;

import my.learning.javarush.st3.agreggator.Controller;
import my.learning.javarush.st3.agreggator.vo.Vacancy;

import java.util.List;

public interface View {
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);
}
