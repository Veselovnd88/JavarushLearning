package my.learning.javarush.st3.url.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class GetSocket {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            System.out.println(url.getHost());
            System.out.println(url.getPath());
            Socket socket = new Socket(url.getHost(), 80);
            OutputStream os = socket.getOutputStream();
            os.write(("GET"+url.getPath()).getBytes());
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while(!((line=br.readLine()) ==null)){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
