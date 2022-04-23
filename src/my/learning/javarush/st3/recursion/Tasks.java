package my.learning.javarush.st3.recursion;

public class Tasks {
    public static void fibtask(){
        System.out.println(fibonacci(9));     //34
        System.out.println(fibonacci(5));     //5
        System.out.println(fibonacci(2));     //1
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(3));

    }
    public static int fibonacci(int n){
        if(n==1){
            return 1;
        }
        if (n==2){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
