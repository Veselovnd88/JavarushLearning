package my.learning.javarush.st3.shortener.strategy;

import java.io.Serializable;

public class Entry implements Serializable {
     Long key;
     String value;
    Entry next;
    int hash;

    public Entry(int hash,Long key, String value, Entry next){
        this.hash = hash;
        this.key=  key;
        this.value = value;
        this.next = next;
    }
    public Long getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }
    public int hashCode(){
        return key.hashCode()+value.hashCode();
    }
    public boolean equals(Object o){
        if(!(o instanceof Entry) || o==null){
            return false;
        }
        else{
            Entry e = (Entry) o;
            return this.key==e.key && this.value==e.value;


        }

    }
    public String toString(){
        return key+"="+value;
    }


}
