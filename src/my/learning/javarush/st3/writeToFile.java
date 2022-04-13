package my.learning.javarush.st3;

import java.io.*;
import java.util.Random;

public class writeToFile {

        public static void task(String[] args) throws IOException {
        String filename = args[0];
        int pos = Integer.parseInt(args[1]);
        String text = args[2];


        RandomAccessFile raf = new RandomAccessFile(filename,"rw");
        if(pos<raf.length()){
            raf.seek(pos);

        }
        else{
            raf.seek(raf.length());
                    }
        raf.write(text.getBytes());





    }

        public static void task2(String[] args) throws IOException{
            String filename = args[0];
            int pos = Integer.parseInt(args[1]);
            String text = args[2];


            RandomAccessFile raf = new RandomAccessFile(filename,"rw");

            byte[] bytes = new byte[text.length()];
            raf.seek(pos);
            raf.read(bytes,0,text.length());
            String newString = new String(bytes);
            raf.seek(raf.length());
            if(newString.equals(text)){
                raf.write("true".getBytes());
            }
            else{
                raf.write("false".getBytes());
            }


        }

        public static void stringwriterreader() throws IOException {
            StringWriter writer = getAllDataFromInputStream(new FileInputStream("src/my/learning/javarush/st3/allFilesContent.txt"));
            System.out.println(writer.toString());
        }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        StringWriter sw  = new StringWriter();
        if(is!=null){
            char[] buffer = new char[1024];

            try(
                Reader r = new BufferedReader(new InputStreamReader(is))){
                int length;
                while ((length = r.read(buffer))!=-1){
                    sw.write(buffer,0,length);
                }

            }
        }

        return sw;



    }

    public static String getStackTrace(Throwable throwable){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        throwable.printStackTrace(pw);
        return sw.toString();

    }

    public static void task5() throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }
    public static String decode(StringReader reader, int key) throws IOException {
          StringWriter sw = new StringWriter();
          if(reader!=null){
              int c;
              while(!((c=reader.read()) ==-1)){
                  sw.write(c+key);
              }
          }
        return sw.toString();
    }
    public static void task6(){
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }
    public static ByteArrayOutputStream getPassword() {
        //65-90 заглавные 97-122 строчные 48-57 цифры   91-96 58-64
        Random random = new Random();


        char[] b = new char[8];
       //b[0] = (byte) num;
       boolean hasUpper = false;
       boolean hasLower = false;
       boolean hasDigit = false;
       while(!(hasDigit&&hasLower&&hasUpper)){
       for(int i=0; i<b.length; i++){
           int choose = random.nextInt(3);
           //System.out.println(choose);
           if (choose==0){
               //65-90 заглавные 97-122 строчные 48-57 цифры
               b[i] = (char) (random.nextInt(26)+65);

               hasUpper = true;
           }
           else if(choose==1){
                b[i] = (char) (random.nextInt(26)+97);
                hasLower=true;
           }
           else {
               b[i] = (char) (random.nextInt(10)+48);
               hasDigit=true;
           }
       }}
       ByteArrayOutputStream bos = null;
       String result = new String(b);
        //System.out.println(result);
       try {
       bos = new ByteArrayOutputStream();
       bos.write(result.getBytes());
       }
       catch (IOException e){
           e.printStackTrace();
       } return bos;
        //String str = new String(b);
        //System.out.println(str)
    }


}
