package my.dukeuniversity.shapes.csv;
import edu.duke.*;

import org.apache.commons.csv.*;


public class ExampleCsv {

    public static void task(){
        FileResource fr = new FileResource("src/my/dukeuniversity/shapes/csv/exportdata.csv");
        FileResource frsmall = new FileResource("src/my/dukeuniversity/shapes/csv/exports_small.csv");
        //CSVParser parser = fr.getCSVParser();
        //String export = "footwear";

        CSVParser f = fr.getCSVParser();
        CSVParser p = frsmall.getCSVParser();
        //listExporters(f,"sugar");
        String c = "Nauru";
       // System.out.println(countryInfo(f,c));
        //listExportersTwoProducts(f,"gold","diamonds");
        //System.out.println(numberOfExporters(p,"gold"));
        bigExporters(f,"$999,999,999,999");
    };


    public static void readFood(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord r : parser){
            System.out.println(r.get("Name"));

        }
    }
    public static void listExporters(CSVParser parser, String exportOfInterest){
        int count = 0;
        for(CSVRecord record: parser){

            if(record.get("Exports").contains(exportOfInterest)){
                System.out.println(record.get("Country"));
                count++;
        }

        }
        System.out.println(count);


    }

    public static String countryInfo(CSVParser parser, String country){
        for(CSVRecord r: parser){
            if (r.get("Country").equals(country)){
                return (r.get("Country")+": "+ r.get("Exports"));
            }
        }return "NOT FOUND";

    }
    public static void listExportersTwoProducts(CSVParser parser, String exp1, String exp2){
        for(CSVRecord r: parser){
            String c = r.get("Exports");
            //System.out.println(c);
            if(c.contains(exp1) && c.contains(exp2)){
                System.out.println(r.get(0));
            }
        }
    }

    public static int numberOfExporters(CSVParser parser, String item){
        int count = 0;
        for(CSVRecord r: parser){
            if(r.get("Exports").contains(item)){
                count++;
            }
        } return count;
    }
    public static void bigExporters(CSVParser parser, String amount){
        for( CSVRecord r: parser){
            if(r.get(2).length()>amount.length()){
                System.out.println(r.get(0));
            }
        }

    }
}
