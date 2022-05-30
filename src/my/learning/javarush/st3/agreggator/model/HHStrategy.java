package my.learning.javarush.st3.agreggator.model;

import my.learning.javarush.st3.agreggator.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        final String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko)" +
                " Chrome/101.0.4951.64 Safari/537.36 OPR/87.0.4390.25";
        Document doc = null;
        try {
            doc = Jsoup.connect("https://javarush.ru/testdata/big28data.html").userAgent(userAgent)
                    .referrer("https://hh.ru").get();

            Elements els = doc.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy");
            for(Element el:els){
                System.out.println(el.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-title"));
            }
        } catch (IOException e){
            e.printStackTrace();
        }



        List<Vacancy> vacancies = new ArrayList<>();
        return vacancies;
    }
}
