package my.learning.javarush.st2.serialization;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesTraining {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties pr = new Properties();
        pr.putAll(runtimeStorage);
        pr.store(outputStream,null);

    }

    public static void load(InputStream inputStream) throws IOException {
        Properties pr = new Properties();
        pr.load(inputStream);
        runtimeStorage = new HashMap<>((Map)pr);
    }

    public static void task(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
