package my.learning.javarush.st3.agreggator.model;

import my.learning.javarush.st3.agreggator.vo.Vacancy;

import java.util.List;

public class Provider {// класс отвечает за получения данных с сайта
    private Strategy strategy;// стратегия



    public Provider(Strategy strategy){
         this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public List<Vacancy> getJavaVacancies(String searchString){

        return strategy.getVacancies(searchString);
    }


}
