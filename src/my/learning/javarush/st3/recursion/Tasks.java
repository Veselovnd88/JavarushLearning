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
    public static void factTask(){
        System.out.println(factorial(9));     //362880
        System.out.println(factorial(0));     //1
        System.out.println(factorial(1));     //1
    }
    public static int factorial(int n){
        if (n == 0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void recurseTask(){
        recurse(132);
    }
    public static void recurse(int n){
        if(n<=1){
            return;
        }
        for( int i=2; i<=n; i++){
            if(n%i==0){
                System.out.print(i+" ");
                recurse(n/i);
                break;
            }
        }

    }
}
