package my.learning.javarush.st3.proxyconn.connectors;

import my.learning.javarush.st3.proxyconn.security.SecurityChecker;
import my.learning.javarush.st3.proxyconn.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector{
    private SecurityChecker sc;
    private SimpleConnector connector;

    public SecurityProxyConnector(String resource){
        this.connector = new SimpleConnector(resource);
        this.sc = new SecurityCheckerImpl();
    }



    @Override
    public void connect() {

        if(sc.performSecurityCheck()){
            connector.connect();}
        else{
            System.out.println("Соединение небезопасно");
        }
    }
}
