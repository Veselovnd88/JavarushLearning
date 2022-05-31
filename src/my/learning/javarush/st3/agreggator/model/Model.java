package my.learning.javarush.st3.agreggator.model;

import my.learning.javarush.st3.agreggator.view.View;
import my.learning.javarush.st3.agreggator.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        if(providers==null || providers.length==0|| view==null){
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;
    }


    public void selectCity(String city){
        List<Vacancy> vacancyList = new ArrayList<>();
        for (Provider p: providers){
            vacancyList.addAll(p.getJavaVacancies(city));
        }
        view.update(vacancyList);
    }
}
