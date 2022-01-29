package my.learnquest.part4.store;

import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

public class Artist {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private SortedSet<String> memberNames;
    private Map<String, SortedSet<String>> memberInstruments;

    public Artist() {
        memberNames = new TreeSet();
        memberInstruments = new TreeMap();
    }

    public Artist(String name, SortedSet<String> memberNames, Map<String, SortedSet<String>> memberInstruments) {
        super();
        setName(name);
        this.memberNames = memberNames;
        this.memberInstruments = memberInstruments;
    }

    public void addMembers(String name, SortedSet<String> instruments){
        memberNames.add(name);
        memberInstruments.put(name,instruments);
    }
    public SortedSet<String> getMembers(){
        return memberNames;
    }
    public SortedSet<String> getInstruments(String name){
        return memberInstruments.get(name);
    }
}
