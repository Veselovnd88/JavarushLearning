package my.learning.javarush.arrays;


public class OctalDecimals {

    public static int toOctal(int decimalNumber) {
        if (decimalNumber<=0){
            return 0;
        }
        int i=0;
        int result = 0;
        while(decimalNumber!=0){
            result+=(decimalNumber%8)*Math.pow(10,i);
            decimalNumber/=8;
            i++;
        }
        return result;
    }

    public static int toDecimal(int octalNumber) {
        if (octalNumber<=0){
            return 0;
        }
        int i=0;
        int result = 0;
        while(octalNumber!=0){
            result+=(octalNumber%10)*Math.pow(8,i);
            octalNumber/=10;
            i++;
        }
        return result;
    }

    public static String toBinary(int decimalNumber) {
        StringBuilder sb = new StringBuilder();

        if (decimalNumber<=0){
         return "";}
        //String binary = "";

        while (decimalNumber!=0){
            sb.append(decimalNumber % 2);
            decimalNumber/=2;
        } return sb.toString();

    }

    public static int toDecimal(String binaryNumber) {
        int dig;

        if (binaryNumber==null ||binaryNumber.equals("")){
            return 0;
        }
        int dec = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(binaryNumber.length() - 1 - i)=='0'){
                dig =0;
            }
            else {dig =1;}
            dec =dec + dig* (int) Math.pow(2,i);
        }
        return dec;
    }

}
