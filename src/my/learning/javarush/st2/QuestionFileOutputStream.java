package my.learning.javarush.st2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream strm;

    public QuestionFileOutputStream(AmigoOutputStream strm){
        this.strm = strm;
    }



    @Override
    public void flush() throws IOException {
        strm.flush();
    }

    @Override
    public void write(int b) throws IOException {
        strm.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        strm.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        strm.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();
        if(answer.equals("Д")){
            strm.close();
        }
    }
}
