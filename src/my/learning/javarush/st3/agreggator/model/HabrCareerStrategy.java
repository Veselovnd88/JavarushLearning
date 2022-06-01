package my.learning.javarush.st3.agreggator.model;

import my.learning.javarush.st3.agreggator.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerStrategy implements Strategy {
    private final String URL_FORMAT = "https://javarush.ru/testdata/big28data2.html";

    public void test() throws IOException {


    }


    protected Document getDocument(String searchingString, int page) throws IOException {
        final String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko)" +
                " Chrome/101.0.4951.64 Safari/537.36 OPR/87.0.4390.25";
        //File file = new File("src/my/learning/javarush/st3/agreggator/sample.html");
        //  return Jsoup.parse(file,"UTF-8");
        return Jsoup.connect(URL_FORMAT).userAgent(userAgent)
                .referrer("https://career.habr.com/").get();
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        int page = 0;
        List<Vacancy> vacancies = new ArrayList<>();
        Document doc = null;
        try{
            do {
                doc = getDocument(searchString, page);
                Elements elements = doc.getElementsByClass("job");
                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName("https://career.habr.com/");
                    Elements titles = element.getElementsByClass("title");
                    vacancy.setTitle(titles.get(0).text());
                    Elements city = element.getElementsByClass("location");
                    vacancy.setCity(city.size() > 0 ? city.get(0).text() : "");
                    Elements companyName = element.getElementsByClass("company_name");
                    vacancy.setCompanyName(companyName.get(0).getElementsByTag("a").text());
                    Elements salary = element.getElementsByClass("salary");
                    vacancy.setSalary(salary.size() > 0 ? salary.get(0).text() : "Не указано");
                    vacancy.setUrl("https://career.habr.com" + titles.get(0).getElementsByTag("a").attr("href"));
                    // System.out.println(vacancy.getCompanyName());
                    //System.out.println(vacancy.getCity());
                    vacancies.add(vacancy);
                }
                page++;
            } while (page<1);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return vacancies;
    }
}
