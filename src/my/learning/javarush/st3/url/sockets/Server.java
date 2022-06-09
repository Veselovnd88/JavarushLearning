package my.learning.javarush.st3.url.sockets;

import java.net.ServerSocket;
import java.net.Socket;

/*
Сокетный сервер и клиент
*/

public class Server {

    public static void main(String[] args) {
        int port = 4444;//определили порт

        try (ServerSocket serverSocket = new ServerSocket(port)) {//создан сервер сокет на порту
            while (true) {
                Socket socket = serverSocket.accept();//включено прослушивание соединене
                new Handler(socket).start();//передан в новый поток для создание соединения
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Connection connection = new Connection(socket)) {//тут создано соединение на сокете(клиентском, которое присоединилось к сепрверу
                while (true) {
                    String message = connection.receive();//получили сообщение от клиента - ждет (т.е. поток out блокирован) и опять ждет

                    if (message.equals("exit"))//когда получили сообщение поток разблокированлая
                        break;

                    System.out.println(message);//сервер пишет месседж

                    connection.send("Echo: " + message);//отправляет обратно сообщение в инпутстрим
                }
            } catch (Exception e) {
            }
        }

    }
}
