package my.learning.javarush.arrays;

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
}
