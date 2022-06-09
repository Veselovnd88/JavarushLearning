package my.learning.javarush.st3.url.sockets;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
Сокетный сервер и клиент
*/

public class Connection implements Closeable {
    private final Socket socket;//есть сокет
    private final ObjectInputStream in;//стримы для передачи объектов
    private final ObjectOutputStream out;

    public Connection(Socket socket) throws Exception {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());// сразу открывает на переданном сокете стримы -







    }

    public void send(String message) throws Exception {

        out.writeObject(message);
    }

    public String receive() throws Exception {
        return (String) in.readObject();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}

