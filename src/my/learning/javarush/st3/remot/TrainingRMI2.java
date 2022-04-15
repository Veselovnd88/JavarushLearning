package my.learning.javarush.st3.remot;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TrainingRMI2 {
    public static Registry registry;
    public static final String DOG = "dog.method";
    public static final String CAT = "cat.method";
    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {

            try {
                final Animal dog = new Dog("Jopa");
                final Animal cat = new Cat("Pipka");

                registry = LocateRegistry.createRegistry(2099);
                Remote stubdog  = UnicastRemoteObject.exportObject(dog,0);
                Remote stubcat = UnicastRemoteObject.exportObject(cat,0);

                registry.bind(DOG,stubdog);
                registry.bind(CAT,stubcat);

            } catch (RemoteException e) {
                e.printStackTrace(System.err);
            } catch (AlreadyBoundException e) {
                e.printStackTrace(System.err);
            }


        }
    });

    public static void task() throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        SERVER_THREAD.join();
        Thread.sleep(1000);

        // Start the client
        CLIENT_THREAD.start();
        Thread.sleep(5000);

    }

}
