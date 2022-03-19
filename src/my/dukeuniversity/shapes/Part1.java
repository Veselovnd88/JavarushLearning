package my.dukeuniversity.shapes;

import edu.duke.FileResource;
import edu.duke.StorageResource;

import java.util.Locale;

public class Part1 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon){

       int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while(currIndex!=-1){
            //System.out.println(currIndex);
            if((currIndex-startIndex)%3==0){
                return currIndex;
            }
            else {currIndex = dna.indexOf(stopCodon,currIndex+1);
                //System.out.println(currIndex);
                            }}
        return dna.length();
     }
     public static String findGene(String dna, int start){
        int closest = 0;
        int startIndex = dna.indexOf("atg",start);
        if(startIndex==-1){
            return "";
        }
        else{
            int indextaa = findStopCodon(dna,startIndex,"taa");
            int indextag = findStopCodon(dna,startIndex,"tag");
            int indextga = findStopCodon(dna,startIndex,"tga");
            closest = Math.min(Math.min(indextaa,indextag),indextga);
        }
            if (closest!=dna.length()){

            return dna.substring(startIndex,closest+3);}
            else {return "";}
     }
     public static void printAllGenes(String dna){
        dna = dna.toLowerCase();
        int count = 0;
        int curr = 0;
        while (true){
            String gene = findGene(dna,curr);

          if(gene.isEmpty()){
              break;
          } System.out.println(gene);
          if (gene.length()>60){
          count++;}
            curr = dna.indexOf(gene, curr)+ gene.length();
        }
         System.out.println(count);

     }
    public static void testFindStopCodon(){
        String a = "cccatggggtttaaataataataggagagagagagagagttt";
        String ap = "atggggtttaaataataatag";
        //String a = "atgcctag";
        //String ap = "";
        //String a = "ATGCCCTAG";
        //String ap = "ATGCCCTAG";
        System.out.println(findStopCodon(a,0,"taa"));
        //System.out.println(ap.length());

    }
    public static void testFindGene(){
        String a = "AATGCTAACTAGCTGACTAAT".toLowerCase();
        String ap = "atgtgagggtttaaatayyyatayyyatag";
        //String a = "atgcctag";
        //String ap = "";
        //String a = "ATGCCCTAG".toLowerCase();
        //String ap = "ATGCCCTAG".toLowerCase();
        printAllGenes(a);
        printAllGenes(ap);
    }
    public static void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || index >= input.length() - 3) {
                break;
            }
            String found = input.substring(index+1, index+4);

            System.out.println(found);
            System.out.println(index);
            index = input.indexOf("abc", index+3);
            System.out.println("index after updating " + index);
           // if (index > input.length() - 3){
              //  break;
           // }

        }
    }

    public static StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int curr = 0;
        while (true){
            String gene = findGene(dna,curr);

            if(gene.isEmpty()){
                break;
            } geneList.add(gene);
            curr = dna.indexOf(gene, curr)+ gene.length();
        }
        return geneList;
    }

    public static float cgRatio(String dna){
        dna = dna.toUpperCase();
        int count = 0;

        for(int i=0; i<dna.length();i++){
            if(dna.charAt(i)=='C' || dna.charAt(i)=='G'){
            count++;
                //System.out.println(count);
            }
        } return (float) count/dna.length();

    }
    public static int countCTG(String dna){
        dna = dna.toUpperCase();
        int count=0;
        int curr = dna.indexOf("CTG");
        while (curr!=-1){
            count++;
            curr = dna.indexOf("CTG",curr+3);

        } return count;
    }
    public static void processGenes (StorageResource sr){
        int longest = 0;
        int all = 0;
        int count9 = 0;
        int countcg = 0;
        int count3 = 0;
        for(String s: sr.data()){
            if(s.length()>longest){
                longest = s.length();
            }
            all++;
                if( s.length()>60){
                    //System.out.println(s.length());
                count9++;
                System.out.println("Longer than 60");
                System.out.println(s);
            }
                if (cgRatio(s)>0.35){
                    countcg++;
                    System.out.println("cgRatio> 0.35");
                    System.out.println(s);
                }

        }
        System.out.println("number >60 is "+ count9);
        System.out.println("count cg>0.35 is "+ countcg);
        System.out.println("ctg count us "+ count3);
        System.out.println("Всего "+ all);
        System.out.println("longest gene is "+ longest);
    }
    public static String mystery(String dna) {
        //AATGCTAACTAGCTGACTAAT
        int pos = dna.indexOf("T");//found index for first T is 2
        int count = 0;
        int startPos = 0;
        String newDna = "";
        if (pos == -1) {
            return dna;// if not found return full string
        }
        while (count < 3) {
            count += 1;
            newDna = newDna + dna.substring(startPos,pos);//take part from start po to pos of found T (not included)
            System.out.println(newDna);
            startPos = pos+1;//increase pos number
            pos = dna.indexOf("T", startPos);// and go searhing
            if (pos == -1) {
                break;
            }
        }
        newDna = newDna + dna.substring(startPos);
        return newDna;
    }
    public static void test() {
        FileResource fr = new FileResource("src/my/dukeuniversity/shapes/GRch38dnapart.fa");
        String dna = fr.asString().toLowerCase();
        System.out.println(countCTG(dna.toUpperCase()));
        String a = "AATGCTAACTAGCTGACTAAT";
        //System.out.println(mystery(a));
        //processGenes(getAllGenes(dna));

    }

}
