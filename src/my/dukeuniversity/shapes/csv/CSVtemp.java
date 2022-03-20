package my.dukeuniversity.shapes.csv;
import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class CSVtemp {

    public static void task(){
        //FileResource fr = new FileResource("src/my/dukeuniversity/shapes/csv/nc_weather/2015/weather-2015-01-07.csv");
        CSVRecord c = hottestInManyDays();
        System.out.println(c.get("TemperatureF")+":"+ c.get("DateUTC"));
    }
    public static CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for (CSVRecord r: parser){
            if(largestSoFar ==null){
                largestSoFar = r;
            }
            else {
                double currentTemp = Double.parseDouble(r.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if (currentTemp>largestTemp){
                    largestSoFar = r;

                }
            }
        } return largestSoFar;
    }
    public static CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = hottestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(current,largestSoFar);
            }return largestSoFar;
        }
    public static CSVRecord getLargestOfTwo(CSVRecord current, CSVRecord largestSoFar){
        if(largestSoFar==null){
            largestSoFar = current;
        }
        else {
            double currTemp = Double.parseDouble(current.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if(currTemp>largestTemp){
                largestSoFar = current;
            }
    } return largestSoFar;}

}
