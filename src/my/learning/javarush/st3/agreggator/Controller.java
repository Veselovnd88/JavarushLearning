package my.learning.javarush.st3.agreggator;

import my.learning.javarush.st3.agreggator.model.HHStrategy;
import my.learning.javarush.st3.agreggator.model.Provider;
import my.learning.javarush.st3.agreggator.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {// класс в котором будет содержаться логика работы программы
    private Provider[] providers;

    public Controller(Provider...providers){// сюда передаются провайдеры для дальнейшей  проработки
        if(providers==null || providers.length==0){
            throw new IllegalArgumentException();
        }
        else{
            this.providers = providers;}
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<Vacancy> vacancy = new ArrayList<>();
        for(Provider p: providers){
            vacancy.addAll(p.getJavaVacancies(null));
        }
        System.out.println(vacancy.size());
    }
}
