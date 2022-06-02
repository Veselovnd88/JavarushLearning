package my.learning.javarush.st3.level9;

import java.util.HashMap;
import java.util.Map;

public class palindromeTask {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("vvcvcvv"));
    }


    public static boolean isPalindromePermutation(String s) {
        boolean result = true;
        String str = s.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int count = map.get(str.charAt(i)) + 1;
                map.put(str.charAt(i), count);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odd++;
            }
        }
        System.out.println(odd);
        if (odd > 1) {
            return false;
        } else {
            return true;
        }
    }
}
