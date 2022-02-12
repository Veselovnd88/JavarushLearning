package my.learning.javarush.arrays;

import java.io.*;
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
}
