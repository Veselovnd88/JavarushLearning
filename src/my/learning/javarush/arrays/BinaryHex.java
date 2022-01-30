package my.learning.javarush.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryHex {
    private static String hexes  = "0123456789abcdef";
    private static List<String> bins = new ArrayList<String>();
    private static String[] binaries = new String[] {"0000", "0001", "0010", "0011", "0100", "0101", "0110",
            "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    public static String toHex(String binaryNumber) {

        bins = Arrays.asList(binaries);

        if (binaryNumber==null || binaryNumber.equals("")){
            return "";
        }
        StringBuilder result = new StringBuilder();
        StringBuilder full = new StringBuilder();
        if(binaryNumber.length()%4!=0){
            full.append(binaryNumber);
            for( int i=0; i<(binaryNumber.length()%4);i++){
            full.insert(0,"0");
            }
            binaryNumber = full.toString();
        }
        for(int i=0; i<binaryNumber.length(); i+=4){
           result.append(Character.toString(hexes.charAt(bins.indexOf(binaryNumber.substring(i,i+4)))));
        }
        return result.toString();
}}
