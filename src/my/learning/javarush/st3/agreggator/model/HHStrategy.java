package my.learning.javarush.st3.agreggator.model;

import my.learning.javarush.st2.AdapterFileOutputStream;
import my.learning.javarush.st3.agreggator.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy{

    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&from=suggest_post&fromSearchLine=true&area=1&page=%d&hhtmFrom=vacancy_search_list";

    public void test(){
        System.out.println(String.format(URL_FORMAT, "Moscow",2));
    }

    protected Document getDocument(String searchingString, int page) throws IOException{
        final String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko)" +
                " Chrome/101.0.4951.64 Safari/537.36 OPR/87.0.4390.25";
        File file = new File("src/my/learning/javarush/st3/agreggator/sample.html");
        return Jsoup.parse(file,"UTF-8");
        //return Jsoup.connect(String.format(URL_FORMAT,searchingString,page)).userAgent(userAgent)
          //      .referrer("https://hh.ru/").get();
    }
    @Override
    public List<Vacancy> getVacancies(String searchString){
        //if(searchString==null){
         //   return Collections.emptyList();
       // }
        int page = 0;
        Document doc = null;
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            do {
                doc = getDocument(searchString, page);
                //System.out.println(doc);
                Elements els_premium = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy vacancy-serp__vacancy_premium");
                Elements els_standard_plus = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy vacancy-serp__vacancy_standard_plus");



                if(els_premium.isEmpty() && els_standard_plus.isEmpty()) break;
                for(Element el: els_premium){
                    Elements links = el.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");

                    //System.out.println(links.get(0).text());
                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName("hh.ru");
                    vacancy.setTitle(links.get(0).text());
                    vacancy.setUrl(links.get(0).attr("href"));


                    System.out.println(vacancy.getTitle());
                    System.out.println(vacancy.getUrl());


                }
                for(Element el: els_standard_plus){
                    Elements links = el.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
                    //System.out.println(links.get(0).text());
                }
                page++;

            } while(page<1);

        }             catch(IOException e){
            e.printStackTrace();

        }


        return vacancies;
    }
}
