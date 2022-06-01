package my.learning.javarush.st3.agreggator;

import my.learning.javarush.st3.agreggator.model.HHStrategy;
import my.learning.javarush.st3.agreggator.model.HabrCareerStrategy;
import my.learning.javarush.st3.agreggator.model.Model;
import my.learning.javarush.st3.agreggator.model.Provider;
import my.learning.javarush.st3.agreggator.view.HtmlView;
import my.learning.javarush.st3.agreggator.view.View;

import java.io.IOException;

public class Aggregator {
    public static void main(String[] args) {
      Provider provider = new Provider(new HHStrategy());
      Provider provider1 = new Provider(new HabrCareerStrategy());
      provider1.getJavaVacancies(null);
       HtmlView view = new HtmlView();
       Model model = new Model(view,provider1);
       Controller controller = new Controller(model);
       view.setController(controller);
       view.userCitySelectEmulationMethod();





    }
}
