package my.learning.javarush.st3.agreggator.view;

import my.learning.javarush.st3.agreggator.Controller;
import my.learning.javarush.st3.agreggator.vo.Vacancy;

import java.util.List;

public class HtmlView implements View{
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Moscow");
    }
}
