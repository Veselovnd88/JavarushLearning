package my.learning.javarush.st2.bonustasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TagsTask {
    /*
src/my/learning/javarush/st2/bonustasks/sample.html
     */
    public static void task(String[] args) throws IOException {
        String tag = args[0];
        List<Integer> opens = new ArrayList<>();
        List<Integer> closes = new ArrayList<>();
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //FileReader fr = new FileReader(br.readLine());
        FileReader fr = new FileReader("src/my/learning/javarush/st2/bonustasks/sample.html");
        BufferedReader brFr = new BufferedReader(fr);
        String testedStr;
        StringBuilder sb = new StringBuilder();
        while (brFr.ready()) {

            sb.append(brFr.readLine().replaceAll("[\\n\\r]", ""));
        }

        testedStr = sb.toString();
        int start = 0;
        int ind;
        while(start<testedStr.length()){
            ind = testedStr.indexOf("<"+tag,start);
            if(ind==-1){
                ind=0;
                start=0;
                break;
            }
            opens.add(ind);
            start = ind+1+tag.length();
        }
        while(start<testedStr.length()){
            ind = testedStr.indexOf("</"+tag+">",start);
            if(ind==-1){

                break;
            }
            closes.add(ind);
            start = ind+3+tag.length();
        }
        //System.out.println(opens);
       // System.out.println(closes);

        while (closes.size()>0){
            int startInd = 0;
            for(int i=0; i<opens.size(); i++){

                    int diffMin = Integer.MAX_VALUE;
                    int diff = closes.get(0) - opens.get(i);
                    //System.out.println(diff);
                    if(diff<diffMin && closes.get(0)>opens.get(i)&&opens.size()>1){
                        diff = diffMin;
                    }


                    else{
                        if(opens.size()>1){
                        startInd = opens.get(i-1);}
                        else{
                            startInd = opens.get(i);
                        }

                        //System.out.println(opens);
                        //System.out.println(closes);

                        System.out.println(testedStr.substring(startInd,closes.get(0)+3+tag.length()));
                        closes.remove(0);
                        if(opens.size()>1){
                        opens.remove(i-1);}
                        else{
                            opens.remove(i);
                        }
                        break;}

            }
        }

    }
}
