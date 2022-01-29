package my.learnquest.part4.store;


import java.util.TreeSet;

public class ArtistExerciser {
    private static void printMembersInstruments(Artist artist, String memberName){
        System.out.println(memberName+" plays on ");
        for(String instrument: artist.getInstruments(memberName)){
            System.out.println(instrument);
        }
    }

    public static void main(String[] args) {
        Artist hotPlate = new Artist();
        TreeSet<String> instruments1 = new TreeSet<>();
        instruments1.add("Piano");
        instruments1.add("Clarinet");
        instruments1.add("Hurdy Gurdy");
        instruments1.add("Tuba");
        hotPlate.addMembers("Tom", instruments1);
        TreeSet<String> instruments2 = new TreeSet<>();
        instruments2.add("Guitar");
        instruments2.add("Drums");
        instruments2.add("Bass");
        instruments2.add("Bagpipe");
        hotPlate.addMembers("Steeve", instruments2);
        printMembersInstruments(hotPlate,"Steeve");
    }
}
