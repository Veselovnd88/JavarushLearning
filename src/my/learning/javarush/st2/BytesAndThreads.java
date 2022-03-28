package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BytesAndThreads {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    //   src/my/learning/javarush/st2/out1.txt
    //  src/my/learning/javarush/st2/out2.txt
    public static void task(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while(true){
                line = br.readLine();
                if(line.equals("exit")){
                    break;
                }
                Thread thr = new ReadThread(line);
                thr.start();

            }br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(resultMap);
    }


    public static class ReadThread extends Thread {
        private Map<Integer, Integer> myMap = new HashMap<>();
        private String file;
        public ReadThread(String fileName) {
            this.file = fileName;
        }
        @Override
        public void run(){
            try {
                FileReader fr = new FileReader(this.file);
                int b;
                while((b=fr.read())!=-1){
                    if(myMap.containsKey(b)){
                        myMap.put(b,myMap.get(b)+1);
                    }
                    else {myMap.put(b,1);}
                }
                int max=0;

                for(Map.Entry<Integer, Integer> en: myMap.entrySet()){
                    if(en.getValue()>=max){
                        max = en.getKey();
                                        }
                }
                resultMap.put(file,max);
                fr.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
}

}
