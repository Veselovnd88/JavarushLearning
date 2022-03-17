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
    public static void testFindStopCodon(){
        String a = "cccatggggtttaaataataataggagagagagagagagttt";
        String ap = "atggggtttaaataataatag";
        //String a = "atgcctag";
        //String ap = "";
        //String a = "ATGCCCTAG";
        //String ap = "ATGCCCTAG";
        System.out.println(findStopCodon(ap,0,"taa"));
        //System.out.println(ap.length());

    }

}
