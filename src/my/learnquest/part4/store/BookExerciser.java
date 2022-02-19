package my.learnquest.part4.store;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class BookExerciser {
    public static void main(String[] args) {

        String loc = "src/my/learnquest/part4/store/booksrc.txt";
        List<Book> books = readBooksFromFile(loc);
        books.forEach(book -> System.out.println(book.getTitle()));
    }
    public static List<Book> readBooksFromFile(String name){
        List<Book> books = null;
        try(FileInputStream fin = new FileInputStream(name);
            InputStreamReader reader = new InputStreamReader(fin);
            LineNumberReader lines = new LineNumberReader(reader)){
        String line;
        books = new ArrayList<>();
        while((line = lines.readLine())!= null){
            System.out.printf("%d: %s%n", lines.getLineNumber(), line);
            String title = line;
            String author = lines.readLine();
            double price = Double.parseDouble(lines.readLine());
            System.out.printf("Book: [Title: %s, Author: %s, Price: $%.2f]%n", title, author,price);
            books.add(new Book(title,author,price,0, "NON-FICTION"));
        }
        }catch (IOException e){
            e.printStackTrace();
        }
        return books;
    }
}
