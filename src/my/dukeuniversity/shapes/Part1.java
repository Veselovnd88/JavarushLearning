package my.dukeuniversity.shapes;

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
     public static String findGene(String dna){
        int closest = 0;
        int startIndex = dna.indexOf("atg",0);
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
        String gene = findGene(dna);
        int curr = 0;
        while (!gene.equals("")){
            System.out.println(gene);
            //System.out.println(dna.length());

            //System.out.println(ind);
            gene = findGene(dna.substring(curr));

        }

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
        String a = "cccatggggtttaaataataataggagagagagagagagtttatgtaaatgtaa";
        String ap = "atgtgagggtttaaatayyyatayyyatag";
        //String a = "atgcctag";
        //String ap = "";
        //String a = "ATGCCCTAG".toLowerCase();
        //String ap = "ATGCCCTAG".toLowerCase();
        printAllGenes(a);
        //printAllGenes(ap);
    }

}
