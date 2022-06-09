/* package my.learning.javarush.st3.url;
import javax.mail.*;
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

            String username = "suffocation666@inbox.ru";
            String password = "";
            props.load(new FileReader(str));
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });


            MimeMessage message = new MimeMessage(session);
            message.addFrom(new Address[]{new InternetAddress("suffocation666@inbox.ru")});
            message.setSubject("Привет");
            message.setText("Это Тестовое письмо");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("veselovnd@gmail.com"));
            message.setSentDate(new Date());




            Transport transport = session.getTransport();// авторизация
            transport.connect((String) props.get("mail.host"),465, (String)props.get("mail.user"),(String) props.get("mail.password"));
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));




        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }
    }



}
*/