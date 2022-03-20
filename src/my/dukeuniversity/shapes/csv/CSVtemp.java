package my.dukeuniversity.shapes.csv;
import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class CSVtemp {

    public static void task(){
        FileResource fr = new FileResource("src/my/dukeuniversity/shapes/csv/nc_weather/2015/weather-2015-01-07.csv");
        CS
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

}
