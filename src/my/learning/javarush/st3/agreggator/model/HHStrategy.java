package my.learning.javarush.st3.agreggator.model;

import my.learning.javarush.st3.agreggator.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy{

    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&from=suggest_post&fromSearchLine=true&area=1&page=%d&hhtmFrom=vacancy_search_list";

    public void test(){
        System.out.println(String.format(URL_FORMAT, "Moscow",2));
    }


    @Override
    public List<Vacancy> getVacancies(String searchString){
        //if(searchString==null){
         //   return Collections.emptyList();
       // }
        final String userAgent = "Mozilla/5.0 (jsoup)";
        try {
            Document doc = Jsoup.connect(String.format(URL_FORMAT, "Moscow", 1)).get();
        } catch (IOException e){
            e.printStackTrace();
        }



        List<Vacancy> vacancies = new ArrayList<>();
        return vacancies;
    }
}
