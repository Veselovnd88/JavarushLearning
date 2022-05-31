package my.learning.javarush.st3.agreggator.view;

import my.learning.javarush.st3.agreggator.Controller;
import my.learning.javarush.st3.agreggator.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath ="src/my/learning/javarush/st3/agreggator/view/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
        try{
            getDocument(filePath);
        //String updated = getUpdatedFileContent(vacancies);
        //updateFile(updated);
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

        return null;
    }
     private void updateFile(String string) throws IOException {
         BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
         bw.write(string);
         bw.flush();
         bw.close();
    }
    protected Document getDocument(String filePath) throws IOException {
        File file = new File(filePath);
        Document doc = Jsoup.parse(file,"UTF-8");
        System.out.println(doc);
        return doc;
    }
}
