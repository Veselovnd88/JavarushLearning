package my.learning.javarush.st2.atm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionTask {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void task() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1= null;
        String file2 = null;
        try{file1 =  br.readLine();
            file2 = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try{
        BufferedReader br2 = new BufferedReader(new FileReader(file1));
        BufferedReader br3 = new BufferedReader(new FileReader(file2));
        String line=null;
        while(!((line=br2.readLine()) ==null)){
            allLines.add(line);
        }
        line = null;
        while(!(((line = br3.readLine())) ==null)){
            forRemoveLines.add(line);
        }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();

        }
        catch (IOException e){
            e.printStackTrace();
        }
        try{
        TransactionTask tsk = new TransactionTask();
        allLines.forEach(System.out::println);
        tsk.joinData();}
        catch (CorruptedDataException e){
            e.printStackTrace();}
        allLines.forEach(System.out::println);
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
            }
        else {allLines.clear();
        throw new CorruptedDataException();}
        }

    }

