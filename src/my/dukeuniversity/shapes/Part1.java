package my.dukeuniversity.shapes;

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
        int startIndex = dna.indexOf("atg",0);
        if(startIndex==-1){
            return "";
        }
        else{
            int indextaa = findStopCodon(dna,startIndex,"taa");
            int indextag = findStopCodon(dna,startIndex,"tag");
            int indextga = findStopCodon(dna,startIndex,"tga");
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

}
