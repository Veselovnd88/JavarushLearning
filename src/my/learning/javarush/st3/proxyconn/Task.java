package my.learning.javarush.st3.proxyconn;

import my.learning.javarush.st3.proxyconn.connectors.Connector;
import my.learning.javarush.st3.proxyconn.connectors.SecurityProxyConnector;
import my.learning.javarush.st3.proxyconn.connectors.SimpleConnector;

public class Task {

    public static void main(String[] args) {
        Connector securityProxyConnector = new SecurityProxyConnector("google.com");
        Connector simpleConnector = new SimpleConnector("javarush.ru");

        System.out.println("Connecting with SimpleConnector...");
        simpleConnector.connect();

        System.out.println("----------------------------------------------------");

        System.out.println("Connecting with SecurityProxyConnector...");
        securityProxyConnector.connect();
    }
}
