package my.learning.javarush.st3.remot;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class DoubleStringImpl implements DoubleString{
    @Override
    public String doubleString(String str) throws RemoteException {

        return str+str;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Объект DoubleStringImpl уничтожен!");
    }
}
