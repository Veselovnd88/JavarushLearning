package my.learning.javarush.st3.level9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TaskLength {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();
        boolean b = Long.bitCount(123123)%2==0;
        System.out.println(b);
        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {

        if(s.length()==0 || s==null){
            return 0;
        }
        int max = 0;
        int pos = 0;
        int i=0;
        String newStr = s;
        while (pos<s.length()){
           // System.out.println(s.length());
        String sub = findSub(newStr);
        if(sub.length()>max){
            max = sub.length();
        }
        //System.out.println(newStr);
        pos= pos+ newStr.indexOf(sub)+sub.length();
        newStr = s.substring(pos);
       // System.out.println(newStr);
        //System.out.println(pos);
        i++;
        }


        return max;
    }
    private static String findSub(String s){
        Set<Character> chars = new HashSet<>();
        for(int i=0; i< s.length(); i++){
            Character ch = s.charAt(i);
            if(chars.contains(ch)){
                //System.out.println("-----");
                //System.out.println(s.substring(0,i));
                return s.substring(0,i);
            }
            else{
                chars.add(ch);
            }
        }

        return s;
    }
}
