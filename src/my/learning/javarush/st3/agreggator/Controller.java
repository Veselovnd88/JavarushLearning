package my.learning.javarush.st3.agreggator;

import my.learning.javarush.st3.agreggator.model.HHStrategy;
import my.learning.javarush.st3.agreggator.model.Model;
import my.learning.javarush.st3.agreggator.model.Provider;
import my.learning.javarush.st3.agreggator.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {// класс в котором будет содержаться логика работы программы
    private Model model;

    public Controller(Model model){// сюда передаются провайдеры для дальнейшей  проработки
        if(model ==null){
            throw new IllegalArgumentException();
        }
        else{
            this.model = model;}
    }
    public void onCitySelect(String city){
        model.selectCity(city);
    }


}
