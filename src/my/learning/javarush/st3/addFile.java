package my.learning.javarush.st3;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class addFile {

    //src/my/learning/javarush/st3/result.mp3
    //src/my/learning/javarush/st3/test1/test.zip

    public static void task(String[] args) throws IOException {
        File file = new File(args[0]);
        //FileOutputStream fos = new FileOutputStream("src/my/learning/javarush/st3/1.txt");

        List<Content> currentArchive = getContent(args[1]);

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(args[1]));
        zos.putNextEntry(new ZipEntry("new/"+file.getName()));// создали файл в папке новое с названием требуемого файла
        Files.copy(file.toPath(), zos);//скопировали нужный файл в наш архив
        zos.closeEntry();
        currentArchive.forEach(x -> {
            if(!x.getName().equals("new/"+file)){
                try {
                    x.save(zos);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        zos.close();
    }
    public static List<Content> getContent(String s) throws IOException {
        List<Content> con= new ArrayList<>();
        ZipInputStream zis = new ZipInputStream(new FileInputStream(s));


            ZipEntry ze;//это зип ентри
            byte[] buffer = new byte[1024];// буффер
            while(!((ze = zis.getNextEntry()) ==null)){ // пока зип ентри не ноль
                ByteArrayOutputStream bos = new ByteArrayOutputStream(); // буфферный поток
                int length = 0;// количество считанных байтов
                while((length = zis.read(buffer))>0){ // пока количество считанных в буффер байтов больше нуля
                    bos.write(buffer,0,length); // читаем в буферный поток
                }
                con.add(new Content(ze.getName(), bos.toByteArray())); // добавляем в наш список - имя файла и массив байтов


        }
    return  con;}

     static class Content{
        private byte[] content;
        private String name;

        public Content(String s, byte[] cont){
            this.content= cont;
            this.name = s;
        }

        public byte[] getContent() {
            return content;
        }
        public String getName() {
            return name;
        }

        void save(ZipOutputStream zos) throws IOException {
            ZipEntry ze = new ZipEntry(name);// создали ентри с именем
            zos.putNextEntry(ze);// поместили ентри в архив
            zos.write(content);//пишем в ентри
            zos.closeEntry();//закрыли ентри


        }
    }



}
