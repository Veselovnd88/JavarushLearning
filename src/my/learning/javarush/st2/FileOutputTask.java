package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileOutputTask {
    public static String firstFileName;
    public static String secondFileName;

    static{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            firstFileName = br.readLine();
            secondFileName = br.readLine();
        } catch (IOException e){

        }
    }

    public static void task() throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String filename;
        StringBuilder sb = new StringBuilder();
        @Override
        public void setFileName(String fullFileName) {
            this.filename = fullFileName;
        }

        @Override
        public String getFileContent() {


            return sb.toString().trim();
        }
        @Override
        public void run(){
            try{
                BufferedReader br = new BufferedReader(new FileReader(this.filename));
                String line;
                while(!((line = br.readLine()) ==null)){
                    sb.append(line);
                    sb.append(" ");
                }
            }
            catch (IOException e){

            }
        }
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код
}
