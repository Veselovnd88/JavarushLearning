package my.learning.javarush.st2;

import java.math.BigDecimal;

public class FactorialTask {
    public static String factorial(int n) {
        BigDecimal result = BigDecimal.valueOf(1);
        if (n<0){
            return "0";
        }
        else {

            for(int i=1; i<=n;i++){
                result=result.multiply(BigDecimal.valueOf(i));
            }
        }

        return String.valueOf(result);
    }
}
