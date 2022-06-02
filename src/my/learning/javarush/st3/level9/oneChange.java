package my.learning.javarush.st3.level9;

public class oneChange {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("abcd", "abfcd"));
    }

    public static boolean isOneEditAway(String first, String second){
        if(first.equals(second)){
            return true;
        }//если одинаковые строки то возвращаем тру
        if(first.length()-second.length()>1 || second.length()-first.length()>1){
            return false;// если различие больше чем на 2 символа, возвращаем фолс
        }
        if(first.length()==second.length()){
            char[] arr1 = first.toCharArray();
            char[] arr2 = second.toCharArray();
            int unmatched = 0;
            for (int i=0; i<first.length(); i++){
                if(arr1[i]!=arr2[i]){
                    unmatched++;
                }
            }
            if(unmatched>1){
                return false;
            }
            return true;// проверяем если одинаковые длины - проходим по каждому символу и считаем нессответствия
            //если больше одного - то фолс, если до 1 то тру
        }
        if(first.length()>second.length()){
            return oneChar(first,second);
        }
        else if(second.length()>first.length()){
            return oneChar(second,first);
        }
        if(second.isEmpty()||first.isEmpty()){
            return false;
        }
    return false;
    }

    private static boolean oneChar(String first, String second){
        char[] arr1 =second.toCharArray();//короткий
        char[] arr2 = first.toCharArray();//длинный
        int unmatched =0;
        int p1=0;
        int p2=0;
        for(int i=0; i<second.length();i++){
            if(arr2[i+p2]!=arr1[i+p1]){
                if(arr1[i]!=arr2[i+1]){
                    return false;
                }
                unmatched++;
                p2++;
            }

        }if(unmatched>1){
            return false;
        } return true;
    }
}
