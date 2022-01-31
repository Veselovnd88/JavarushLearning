package my.learning.javarush.arrays;

import java.util.StringTokenizer;

public class PlaywStrings {

    public static int getIndexFromFirstWord(String string, String word) {
        //напишите тут ваш код
        return string.indexOf(word);
    }

    public static int getIndexFromLastWord(String string, String word) {
        //напишите тут ваш код
        return string.lastIndexOf(word);
    }
    public static String changePath(String path, String jdk){
        int index = path.indexOf("jdk");
        int index2 = path.indexOf("/", index);
        String result = path.replaceAll(path.substring(index,index2), jdk);
        return result;
    }
    public static  String[] getTokens(String query, String delimiter){
        StringTokenizer tkn = new StringTokenizer(query, delimiter);
        String[] result = new String[tkn.countTokens()];
        for (int i = 0; tkn.hasMoreTokens(); i++) {
            result[i] = tkn.nextToken();
        }
            return result;
        }

    public static boolean equal(String first, String second){
        return first.intern()==second.intern();
    }
    public static String reverseString(String string){
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }
}
