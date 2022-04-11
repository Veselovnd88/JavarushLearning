package my.learning.javarush.st3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesPlay {
    public static void task(String[] args) {
        PropertiesPlay solution = new PropertiesPlay();
        Properties properties = solution.getProperties("src/my/learning/javarush/st3/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/my/learning/javarush/st3/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/my/learning/javarush/st3/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {

        Properties pr = new Properties();
        try{
        FileInputStream fis  = new FileInputStream(fileName);
        if(fileName.endsWith(".xml")){
            pr.loadFromXML(fis);
        } else {
            pr.load(fis);}
        }
        catch (Exception e){

            //e.printStackTrace();

        }
        return pr;
    }
}
