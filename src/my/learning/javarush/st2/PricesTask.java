package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class PricesTask {

    public static void task(String key, String productName, String price, String quantity){
        if (key!=null){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            //String file = "src/my/learning/javarush/arrays/in.txt";
            BufferedReader filer = new BufferedReader(new FileReader(file));
            if (key.equals("-c")) {
                String id = null;
                String line;
                int max = 0;
                while (!((line = filer.readLine()) == null)) {
                    id = line.substring(0, 8);
                    max = Math.max(Integer.parseInt(id.trim()),max);
                }
                StringBuilder sb = new StringBuilder("\n");
                String newId = String.valueOf(max);
                if( newId.equals("99999999")){
                    newId = "1";
                }else {
                newId = String.valueOf(Integer.parseInt(newId) + 1);}

                System.out.println(newId);

                sb.append(newId);
                if (newId.length() < 8) {
                    for (int i = 0; i < (8 - newId.length()); i++) {
                        sb.append(" ");
                    }
                }
                sb.append(productName);
                if(productName.length()<30){
                    for (int i=0; i< (30-productName.length());i++){
                        sb.append(" ");
                    }
                }
                sb.append(price);
                if(price.length()<8){
                    for(int i=0; i< (8 - price.length()); i++){
                        sb.append(" ");
                    }
                }
                sb.append(quantity);
                if(quantity.length()<4){
                    for(int i=0; i< (4- quantity.length()); i++){
                        sb.append(" ");
                    }
                }



                FileWriter fw = new FileWriter(file, true);


                fw.write(sb.toString());
                fw.flush();
                fw.close();


            }




        }
        catch (Exception e){
            e.printStackTrace();
        }

    }}
}
