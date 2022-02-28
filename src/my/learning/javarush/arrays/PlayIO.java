package my.learning.javarush.arrays;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayIO {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public  static  void example(){
        String src ="/home/nikolay/IdeaProjects/JavarushLearning/src/my/learning/javarush/arrays/log.txt";
        String out ="out.txt";
        try(FileInputStream input = new FileInputStream(src);
            FileOutputStream output = new FileOutputStream(out);){
        byte[] buffer = new byte[65536];
        while(input.available()>0){
            int real= input.read(buffer);
            output.write(buffer,0,real);
        }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void ex2(){
        String src = "src/my/learning/javarush/arrays/log.txt";
        String dst = "src/my/learning/javarush/arrays/out.txt";

        try (FileReader reader  = new FileReader(src);
        FileWriter writer = new FileWriter(dst);){
        char[] buffer = new char[5];

            int real = reader.read(buffer);
            writer.write(buffer, 0, real);

        }
         catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void ex3(){


        try(Scanner sc = new Scanner(System.in);){
        String src = sc.nextLine();
        List<String> my = Files.readAllLines(Paths.get(src));
        my.forEach(str->{
            char[] chars = str.toCharArray();
            for(char c: chars){
                if( c!=','&&c!=' '&&c!='.'){
                    System.out.print(c);
                }
            }System.out.println();
            });
        }
        catch(IOException e){
            e.printStackTrace();
            }

    }
    public static void ex4(){
        try(Scanner sc = new Scanner(System.in)){
            String src = sc.nextLine();
            List<String> my = Files.readAllLines(Path.of(src));
            for (int i = 0; i < my.size(); i+=2) {
                System.out.println(my.get(i));

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void ex5(){
        try (InputStream stream = System.in;//открывается поток который читает консоль
             ) {
            InputStreamReader in = new InputStreamReader(stream);//чтение консоли
            BufferedReader buffer = new BufferedReader(in);// чтение в буфер
            String line = buffer.readLine();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 1) {
                    System.out.print(String.valueOf(chars[i]).toUpperCase());
                } else {
                    System.out.print(String.valueOf(chars[i]).toLowerCase());
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
    public static void ex6(){
        InputStream stream = System.in;
        Scanner sc = new Scanner(stream);
        String str = sc.nextLine();

        System.out.println(Path.of(str).getRoot());
    }
    public static  void ex7(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while(Files.exists(Path.of(str))){
            if(Files.isDirectory(Path.of(str))){
                System.out.println(str+THIS_IS_DIR);
            }else if(Files.isRegularFile(Path.of(str))){
                System.out.println(str+THIS_IS_FILE);
            }str = sc.nextLine();
        }
    }
    public static void ex8(){
        Scanner scanner = new Scanner(System.in);
        Path filePath = Path.of(scanner.nextLine());
        Path fileNewPath = Path.of(scanner.nextLine());
        try{
        if(Files.notExists(filePath)){
            Files.createFile(filePath);
        }
        if(Files.exists(fileNewPath)){
            Files.delete(filePath);
        } else{
        Files.move(filePath,fileNewPath);}
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void ex9(){
        Scanner scanner = new Scanner(System.in);
        Path directory = Path.of(scanner.nextLine());
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(directory)){
            for(Path path: stream){
                if(Files.isRegularFile(path)){
                    System.out.println(path+THIS_IS_FILE);
                }if(Files.isDirectory(path)){
                    System.out.println(path+THIS_IS_DIR);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void ex10(){
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDirectory)){
            for(Path path:stream){
                if(Files.isRegularFile(path)){
                    Path resolve = targetDirectory.resolve(path.getFileName());
                    Files.copy(path,resolve);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void ex11(){
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDirectory)){
            for(Path path:stream){
            if(Files.isRegularFile(path)){
                Path resolved= targetDirectory.resolve(path.getFileName());
                Files.move(path, resolved);
            }}
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void ex12(){
        try{ URL url = new URL("https://javarush.ru");
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        Path file = Files.createTempFile(null,null);
        Files.write(file,buffer);
        }catch (Exception e){
            e.printStackTrace();
        }




    }
    public static void ex13(){
        String image = "https://www.google.ru/images/branding/googlelogo/1x/googlelogo_light_color_272x92dp.png";
        String dest = "C:\\Users\\Nikolay\\IdeaProjects\\JavarushLearning\\src\\my\\learning\\javarush\\arrays\\im.png";
        try{
        URL url = new URL(image);
        InputStream input = url.openStream();
        Files.copy(input, Path.of(dest));}
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void ex14(){
        try{URL url = new URL("https://javarush.ru/api/1.0/rest/projects");
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        System.out.println(str);}
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void ex15(){
      try {
          URL url = new URL("http://httpbin.org/post");//создан экземпляр с ссылкой
          URLConnection conn = url.openConnection(); // открыто соединение
          conn.setDoOutput(true); // разрешили отправлять
          OutputStream out = conn.getOutputStream(); // получили поток на отправку

          PrintStream send = new PrintStream(out); // поток для отправки сообщений
          send.println("Hello");
          InputStream in = conn.getInputStream(); // входящий поток
          BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
          while(buffer.ready()){
              System.out.println(buffer.readLine());
          }
      } catch (Exception e){
          e.printStackTrace();
        }

    }
    public  static  void ex16(){
        try (Scanner sc = new Scanner(System.in);
             FileInputStream fis = new FileInputStream(sc.nextLine());
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr);
        ){
            String line;
            while ((line = br.readLine())!=null){
                System.out.println(line);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static  void ex17(){
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ){String file = br.readLine();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            StringBuilder sb = new StringBuilder();
            String s = "";
            while (s.equals("exit")){
                s = br.readLine();
                sb.append(s);
            }
            bw.write(sb.toString());
            bw.close();



        }


        catch (IOException e){
            e.printStackTrace();
        }
    }

}
