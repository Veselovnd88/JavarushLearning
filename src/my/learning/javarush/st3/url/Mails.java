package my.learning.javarush.st3.url;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


public class Mails {

    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            String str = "src/"+(Mails.class.getPackage().getName()+".").replace(".","/")+"mail.properties";
            System.out.println(str);


            props.load(new FileReader(str));
            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            message.setSubject("Привет");
            message.setText("Это Тестовое письмо");

            message.setSentDate(new Date());



            Transport transport = session.getTransport();// авторизация

            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));




        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }
    }



}
