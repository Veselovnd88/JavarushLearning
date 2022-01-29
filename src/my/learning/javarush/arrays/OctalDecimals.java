package my.learning.javarush.arrays;


public class OctalDecimals {
    private static final String HEX = "0123456789abcdef";
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
    public static String toHex(int decimalNumber){
        StringBuilder sb = new StringBuilder();
        if(decimalNumber<=0){
            return "";
        }
       // sb.append("");
        while (decimalNumber!=0){
           String current = sb.toString();
           sb.append(Character.toString(HEX.charAt(decimalNumber%16)));
            System.out.println(sb.toString());
            //sb.append(current);
         decimalNumber/=16;
        }
        return sb.toString();
    }
    public static int hToDecimal(String hexNumber){
        if(hexNumber==null|| hexNumber.equals("")){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < hexNumber.length(); i++) {
            result = 16 * result + HEX.indexOf(hexNumber.charAt(i));
        } return result;
    }
    public static String toHexb(int decimalNumber){

            if(decimalNumber<=0){
                return "";
            }
            String result="";
            while (decimalNumber!=0){
                String current = result;
                result = Character.toString(HEX.charAt(decimalNumber%16));
                result+=current;
                decimalNumber/=16;
            }
            return result;
    }

}
