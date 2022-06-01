package my.learning.javarush.st3.agreggator.view;

import my.learning.javarush.st3.agreggator.Controller;
import my.learning.javarush.st3.agreggator.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath ="src/my/learning/javarush/st3/agreggator/view/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
        try{
            //getDocument(filePath);
        String updated = getUpdatedFileContent(vacancies);

        updateFile(updated);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(filePath);
        //System.out.println(vacancies.size());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Moscow");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){
        try{
        Document doc = getDocument();
        Elements tmplt = doc.getElementsByClass("template");
        Elements copy_tmplt = tmplt.clone();
        copy_tmplt.removeAttr("style");
        copy_tmplt.removeClass("template");
        Element template =  copy_tmplt.get(0);//получили шаблон
        Elements prevVacancies = doc.getElementsByClass("vacancy");
        for(Element e: prevVacancies){
            if(!e.hasClass("template")){
                e.remove();
            }
        }

        //Добавление новых вакансий
        for(Vacancy v: vacancies){
            Element vacancy_elem = template.clone();
            Element city_elem = vacancy_elem.getElementsByClass("city").get(0);
            city_elem.appendText(v.getCity());
            Element company_elem = vacancy_elem.getElementsByClass("companyName").get(0);
            company_elem.appendText(v.getCompanyName());
            Element salary_elem = vacancy_elem.getElementsByClass("salary").get(0);
            salary_elem.appendText(v.getSalary());
            Element link = vacancy_elem.getElementsByAttribute("href").get(0);
            link.appendText(v.getTitle());
            link.attr("href",v.getUrl());
            tmplt.before(vacancy_elem.outerHtml());
        } return doc.html();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "Some exception occurred";
    }
     private void updateFile(String string) throws IOException {

         BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
         bw.write(string);
         bw.flush();
         bw.close();
    }
    protected Document getDocument() throws IOException {
        File file = new File(filePath);
        Document doc = Jsoup.parse(file,"UTF-8");
       // System.out.println(doc);
        return doc;
    }
}
