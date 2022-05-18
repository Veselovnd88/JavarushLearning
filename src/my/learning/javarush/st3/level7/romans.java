package my.learning.javarush.st3.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class romans {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        HashMap<Character,Integer> table = new HashMap<>();
        table.put('i',1);
        table.put('v',5);
        table.put('x',10);
        table.put('l',50);
        table.put('c',100);
        table.put('d',500);
        table.put('m',1000);
        int result = 0;
        String lowerString = s.toLowerCase();
        for (int j=0; j<lowerString.length()-1; j++){
            Character ch = lowerString.charAt(j);
            Character next = lowerString.charAt(j+1);
            if(table.get(j)<table.get(next)){
                result-=table.get(ch);
            }
            else{
                result+=table.get(ch);
            }


        }
        result+=table.get(lowerString.charAt(lowerString.length()-1));
        return result;

}
}
