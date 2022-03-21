package my.dukeuniversity.shapes.csv;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import javax.sound.midi.Soundbank;
import java.io.File;

public class Babynames {

    public static void task(){
        //totalBirth();//1 task
        //System.out.println("Rank of name and gender is: "+ getRank(2012,"Mason", "M"));
        //System.out.println("Name of rank and gender is: "+ getName(2012,15, "M"));
        //whatIsNameInYear("Isabella", 2012,2014,"F");
        //System.out.println("Highest ranking was at "+yearOfHighestRank("Mason", "M"));
        System.out.println("Average rank is "+ getAverageRank("Jacob","M"));
    }
    public static void totalBirth(){
        System.out.println("TotalBirth task#1 started");
        int countF = 0;
        int countM = 0;
        FileResource fr = new FileResource();
        for (CSVRecord r: fr.getCSVParser(false)){
            if(r.get(1).equals("F")){
                countF++;
            }
            else if(r.get(1).equals("M")){
                countM++;
            }

        }System.out.println("Females qnt: "+ countF);
        System.out.println("Males qnt: "+ countM);
        System.out.println("Total names in file "+ (countF+countM));
    }
    public static int getRank(int year, String name, String gender){
        System.out.println("getRank started for year, " + year+" task 2");
        int rank = 0;
        FileResource fr = new FileResource();
        for (CSVRecord r: fr.getCSVParser(false)){
            if(r.get(1).equals(gender)){
                rank++;
                if(r.get(0).equals(name)){
                    return rank;
                }
            }
        } return -1;
    }

    public static String getName(int year, int rank, String gender){
        System.out.println("getName started, task 3");
        int count = 0;
        String name = null;
        FileResource fr = new FileResource();
        for (CSVRecord r: fr.getCSVParser(false)){
            if(r.get(1).equals(gender)){
                count++;
                if(count ==rank){
                    return r.get(0);
                }
            }
        } return "NO NAME";
    }

    public static void whatIsNameInYear(String name, int year, int newYear, String gender){
        System.out.println("Task 4, define which name should be in new Year rank, rank - of the name in current year");
        System.out.println("Here: current year: "+year+" , Name: "+ name+" new year: "+ newYear);
        int myrank = getRank(year, name, gender);
        String newName = getName(newYear, myrank,gender);
        System.out.println("Name "+ newName+" should be on rank "+ myrank+ " in year "+newYear);
        System.out.printf("%s born in %d would be %s if she was born in %d.",name,year,newName,newYear);

    }
    public static int yearOfHighestRank(String name, String gender){
        System.out.println("Year Of HighestRank started, task5");
        DirectoryResource dr = new DirectoryResource();

        int minRank=Integer.MAX_VALUE;
        int year = 0;
        for (File f: dr.selectedFiles()){
            int rank = 0;
            FileResource fr = new FileResource(f);
            for (CSVRecord r: fr.getCSVParser(false)){
                if(r.get(1).equals(gender)){
                    rank++;
                    if(r.get(0).equals(name)){
                        break;
                    }
                }
            }
            //System.out.println(rank);

            if (rank<minRank){
                minRank=rank;
                year = Integer.parseInt(f.getName().substring(3,7));
            }
        } if(year==0){
            return -1;
        } else{
            return year;
        }
    }
    public static double getAverageRank(String name, String gender){
        System.out.println("This is Average rank task #6");
        DirectoryResource dr = new DirectoryResource();
        int count=0;
        double allRank=0;
        for(File f: dr.selectedFiles()){
                int rank = 0;
                FileResource fr = new FileResource(f);
                for (CSVRecord r: fr.getCSVParser(false)){
                    if(r.get(1).equals(gender)){
                        rank++;
                        if(r.get(0).equals(name)){
                            count++;
                            allRank+=rank;
                            break;
                        }
                    }
                }
        }
    if (count==0){
            return -1;
        }
        else{return (double) allRank/count;}
}
public static int   getTotalBirthsRankedHigher(int year, String name, String gender){
        int birthCount = 0;
}

}
