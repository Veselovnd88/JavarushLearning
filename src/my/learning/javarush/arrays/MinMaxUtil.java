package my.learning.javarush.arrays;

public class MinMaxUtil {
    public static int min(int a, int b){
        return Math.min(a,b);
    }
    public static int min(int a, int b, int c){
        return min(min(a,b),c);
    }
    public static int min (int a, int b, int c, int d){
        return min(min(a,b),min(c,d));
    }
    public static int min(int a, int b, int c, int d, int e){
        return (min(min(a,b,c,d), e));
    }
    public static int max(int a, int b){
        return Math.max(a,b);
    }
    public static int max(int a, int b, int c){
        return max(max(a,b),c);
    }
    public static int max (int a, int b, int c, int d){
        return max(max(a,b),max(c,d));
    }
    public static int max(int a, int b, int c, int d, int e){
        return (max(max(a,b,c,d), e));
    }
}
