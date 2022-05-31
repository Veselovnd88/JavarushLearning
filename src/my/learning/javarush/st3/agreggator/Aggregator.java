package my.learning.javarush.st3.agreggator;

import my.learning.javarush.st3.agreggator.model.HHStrategy;
import my.learning.javarush.st3.agreggator.model.Model;
import my.learning.javarush.st3.agreggator.model.Provider;
import my.learning.javarush.st3.agreggator.view.HtmlView;
import my.learning.javarush.st3.agreggator.view.View;

import java.io.IOException;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(new HHStrategy());
        HtmlView view = new HtmlView();
        Model model = new Model(view,provider);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();



    }
}
