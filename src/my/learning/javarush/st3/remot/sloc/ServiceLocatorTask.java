package my.learning.javarush.st3.remot.sloc;

import java.beans.beancontext.BeanContextServiceProvider;
import java.security.Provider;

public class ServiceLocatorTask {

    public static void task() {
        Service service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
    }
}
