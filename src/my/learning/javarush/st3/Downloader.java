package my.learning.javarush.st3;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Downloader {
    public static void task(String[] args) throws IOException, URISyntaxException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        String ext = urlString.substring(urlString.lastIndexOf('.'));

        String name = urlString.substring(urlString.lastIndexOf('/')+1,urlString.lastIndexOf('.'));
        System.out.println(name+ext);
        Path temp = Files.createTempFile("temp",".temp");
        Files.copy(url.openStream(),temp, StandardCopyOption.REPLACE_EXISTING);
        Path result = downloadDirectory.resolve(name+ext);
        Files.move(temp,result);


        return result;
    }

}
