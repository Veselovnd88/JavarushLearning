package my.learning.javarush.st3.trees;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class TreeSetUsing {
    public static void main(String[] args) {

        // src/my/learning/javarush/st3/1.txt
        String filename = "src/my/learning/javarush/st3/1.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line;
            while(!((line = br.readLine()) ==null)){
                sb.append(line);
            }
            TreeSet<Character> treeSet = new TreeSet<>();
            String myString = sb.toString().toLowerCase();
            for (int i = 0; i < myString.length(); i++) {
                if (myString.charAt(i)>=97 && myString.charAt(i)<=122){


                treeSet.add(myString.charAt(i));}
            }
            if(treeSet.size()<5){
                for(int i=0; i<treeSet.size();i++){
                    System.out.print(treeSet.toArray()[i]);
                }
            }
            else{
                for(int i=0; i<5; i++){
                    System.out.print(treeSet.toArray()[i]);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
