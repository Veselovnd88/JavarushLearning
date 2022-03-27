package my.learning.javarush.st2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PricesTask {
//поменять аргументы

    public static void task(String key,String[] args) {
        if(key.equals("-c")){
            create(args[1],args[2], args[3]);}
        if(key.equals("-u")){
            update(args[1],args[2],args[3],args[4]);
        }
        if(key.equals("-d")){
            delete(args[1]);
        }
    }

    public static void create(String productName, String price, String quantity){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            //String file = "src/my/learning/javarush/arrays/in.txt";
            BufferedReader filer = new BufferedReader(new FileReader(file));

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

                //System.out.println(newId);

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
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(String id, String product, String price, String quantity){
            List<String> list = new ArrayList<>();
            String myId;
            StringBuilder sbId = new StringBuilder();
            sbId.append(id);
            if(id.length()<8){
                for(int i=0; i<(8-id.length());i++){
                    sbId.append(" ");
                }
            }
            myId = sbId.toString();

        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //String file = br.readLine();
            String file = "src/my/learning/javarush/arrays/in.txt";
            BufferedReader filer = new BufferedReader(new FileReader(file));

            String line;

            while (!((line = filer.readLine()) == null)) {
                list.add(line);// filling all  list by lines from file
            }
            for (int i=0; i<list.size();i++){
                if(list.get(i).substring(0,8).equals(myId)){

                    StringBuilder sb = new StringBuilder();
                    sb.append(myId);
                    sb.append(product);
                    if(product.length()<30){
                        for (int j = 0; j < 30- product.length(); j++) {
                            sb.append(" ");
                        }
                    }
                    sb.append(price);
                    if(price.length()<8){
                        for (int j = 0; j < 8- price.length(); j++) {
                            sb.append(" ");
                        }
                    sb.append(quantity);
                        if(quantity.length()<4){
                            for (int j = 0; j < 4- quantity.length(); j++) {
                                sb.append(" ");
                            }

                    list.set(i,sb.toString());
                    //System.out.println(list);
                } } }
            }
            FileWriter fw = new FileWriter(file);
            for (int i=0; i<list.size();i++){
                try {
                    if(i!=0){
                    fw.write("\n");}
                    fw.write(list.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            filer.close();
            fw.flush();
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        }
    public static void delete(String id){
        String myId;
        StringBuilder sbId = new StringBuilder();
        sbId.append(id);
        if(id.length()<8){
            for(int i=0; i<(8-id.length());i++){
                sbId.append(" ");
            }
        }
        myId = sbId.toString();
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            //String file = "src/my/learning/javarush/arrays/in.txt";
            BufferedReader filer = new BufferedReader(new FileReader(file));

            String line;

            while (!((line = filer.readLine()) == null)) {
                list.add(line);// filling all  list by lines from file
            }
            for(int i=0; i<list.size(); i++){
                if(list.get(i).substring(0,8).equals(myId)){
                    list.remove(i);
                    //System.out.println("Удалил");
                }
            }
            FileWriter fw = new FileWriter(file);
            for (int i=0; i<list.size();i++){
                try {
                    if(i!=0){
                        fw.write("\n");}
                    fw.write(list.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            filer.close();
            fw.flush();
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

