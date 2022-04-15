package my.learning.javarush.st3.remot;

import javax.management.MBeanRegistrationException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TrainingRMI {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {

                DoubleString service = (DoubleString) registry.lookup(UNIC_BINDING_NAME);// взяли объект с регистра

                System.out.println(service.doubleString("Hello"));
                Thread.sleep(2000);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException  e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public static void task() throws InterruptedException, NoSuchObjectException {
        // Pretend we're starting an RMI server as the main thread
        Remote stub = null;
        final DoubleStringImpl service = new DoubleStringImpl();//создали объект метода который мы будем вызывать
        try {
            registry = LocateRegistry.createRegistry(2099);// создание регистра


            stub = UnicastRemoteObject.exportObject(service, 0);//создали эту заглушку, в нее передали метод и порт 0

            registry.bind(UNIC_BINDING_NAME, stub);//регистрация заглушки


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        // Start the client

        CLIENT_THREAD.start();
        Thread.sleep(5000);
        UnicastRemoteObject.unexportObject(service, true);//чтобы завершился поток



    }
}
