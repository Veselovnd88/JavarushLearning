package my.dukeuniversity.shapes.csv;
import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class CSVtemp {

    public static void task(){
        //FileResource fr = new FileResource("src/my/dukeuniversity/shapes/csv/nc_weather/2015/weather-2015-01-07.csv");
        //FileResource fr = new FileResource(fileWithColdestTemperature());
        FileResource fr = new FileResource();
        //CSVRecord c = coldestHourInFile(fr.getCSVParser());
        //System.out.println(c.get("TemperatureF")+":"+ c.get("DateUTC"));
        //testFileWithColdestDay();
        testHumidity(fr.getCSVParser());
        //testHumidityManyFiles();
        //testAverageTemperature();
        //testAvTempHum();
    }
    public static void testAvTempHum(){
        FileResource fr = new FileResource();
        System.out.println(averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80));
    }
    public static void testAverageTemperature(){
        FileResource fr =new FileResource();
        System.out.println(averageTemperatureInFile(fr.getCSVParser()));
    }
    public static void testFileWithColdestDay(){
        System.out.println("Filename with coldest day: "+ fileWithColdestTemperature());


    }
    public static void testHumidity(CSVParser parser){
        System.out.println("Day of lowest humidity is "+ lowestHumidityInFile(parser).get("DateUTC"));
    }
    public static void testHumidityManyFiles(){
        CSVRecord result = lowestHumidityInManyFiles();
        System.out.println("Lowest humidity was: "+ result.get("Humidity")+ " "+ result.get("DateUTC"));
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

    public static CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for (CSVRecord r: parser){
            if(r.get("TemperatureF").equals("-9999")){
                continue;
            }
            if(largestSoFar ==null){
                largestSoFar = r;
            }
            else {
                double currentTemp = Double.parseDouble(r.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if (currentTemp<largestTemp){
                    largestSoFar = r;

                }
            }
        } return largestSoFar;}

    public static String fileWithColdestTemperature(){
        String name = null;
        CSVRecord lowestSoFar = null;

        DirectoryResource dr = new DirectoryResource();

        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
            if(lowestSoFar==null){
                lowestSoFar = current;
                name = f.getName();
            }
            else {
                double currTemp = Double.parseDouble(current.get("TemperatureF"));
                double largestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if(currTemp<largestTemp){
                    lowestSoFar = current;
                    name = f.getName();
                }
        }
    }
        System.out.println("Coldest temp is "+lowestSoFar.get("TemperatureF"));
        return name;
}

    public static CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for (CSVRecord r: parser){
            if(!r.get("Humidity").equals("N/A")){
            if(lowestSoFar ==null){

                lowestSoFar = r;}

            else {
                double currentTemp = Double.parseDouble(r.get("Humidity"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("Humidity"));
                if (currentTemp<lowestTemp){
                    lowestSoFar = r;}

                }
            }
        }
        System.out.println("Lowest humidity is "+ lowestSoFar.get("Humidity"));
        return lowestSoFar;
    }

    public static CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowest = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            FileResource fr=  new FileResource(f);
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            lowest = getLowestOfTwo(current,lowest,"Humidity");
        } return lowest;
    }

    public static double averageTemperatureInFile(CSVParser parser){
        double sum = 0;
        int count = 0;
        double result=0;
        for (CSVRecord r: parser){
            sum+=Double.parseDouble(r.get("TemperatureF"));
            count++;
        }result = sum/count; return result;
    }

    public static double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double sum = 0;
        int count = 0;
        double result=0;
        for (CSVRecord r: parser){
            if (!r.get("Humidity").equals("N/A")){
                if( Integer.parseInt(r.get("Humidity"))>=value){

            sum+=Double.parseDouble(r.get("TemperatureF"));
            count++;}}
        } if (count==0){
            System.out.println("No temperatures with such humidity");
            return 0;
        } else{
        result = sum/count;
        return result;}
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
    public static CSVRecord getLowestOfTwo(CSVRecord current, CSVRecord largestSoFar, String token){

        if(largestSoFar==null){
            largestSoFar = current;
        }
        else {
            double currTemp = Double.parseDouble(current.get(token));
            double largestTemp = Double.parseDouble(largestSoFar.get(token));
            if(currTemp<largestTemp){
                largestSoFar = current;
            }
        } return largestSoFar;}

}
