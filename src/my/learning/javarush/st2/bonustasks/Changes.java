package my.learning.javarush.st2.bonustasks;


/*
src/my/learning/javarush/st2/out1.txt
src/my/learning/javarush/st2/out2.txt
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Changes {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static void task(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            FileReader fr1 = new FileReader(br.readLine());
            FileReader fr2 = new FileReader(br.readLine());
            BufferedReader brF1 = new BufferedReader(fr1);
            BufferedReader brF2 = new BufferedReader(fr2);
            List<String> file1 = new ArrayList<>();
            List<String> file2 = new ArrayList<>();
            while(brF1.ready()){
                file1.add(brF1.readLine());
            }
            while (brF2.ready()){
                file2.add(brF2.readLine());
            }
            while(file1.size()>0 &&file2.size()>0){
                if(file1.get(0).equals(file2.get(0))){
                    lines.add(new LineItem(Type.SAME, file1.get(0)));
                    file1.remove(0);
                    file2.remove(0);
                }

                //1     1
                // 2    2
                // 3    3
                //4     4
                else if(!file1.get(0).equals(file2.get(1)) ){//сравниваем первую строку со следующей
                    //если не равна = то значит строку 0 - удалили, соответственно из первого файла тоже удаляем
                    //и начинаем сравнивать следующие
                    lines.add(new LineItem(Type.REMOVED, file1.get(0)));
                    file1.remove(0);
                }
                else { lines.add(new LineItem(Type.ADDED,file2.get(0)));
                        file2.remove(0);
                        /*
                        если же равны - значит строку - добавили. удаляем и начинаем сверять дальше.
                         */

                }
                }
            if(file1.size()>0){
                for(int i=0; i<file1.size(); i++){
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                }}
            else{
                for (int i=0; i<file2.size();i++){
                    lines.add(new LineItem(Type.ADDED, file2.get(i)));
                }
            }
            brF2.close();
            brF1.close();
            fr2.close();
            fr1.close();
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        lines.forEach(x-> System.out.println(x.line+" "+x.type));
    }
    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }



    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }




}
