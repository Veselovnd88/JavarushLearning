package my.learning.javarush.st3;

import my.learning.javarush.st3.proxy.Big;
import my.learning.javarush.st3.proxy.Item;
import my.learning.javarush.st3.proxy.Small;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTraining {

    public static void driver() throws IOException {
        task1();
    }
    public static void task1() throws IOException {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */


    }
    public static SomeInterfaceWithMethods getProxy() {

        SomeInterfaceWithMethods original = new SomeInterfaceWithMethodsImpl();
        ClassLoader cl = original.getClass().getClassLoader();
        Class<?>[] interfaces = original.getClass().getInterfaces();
        CustomInvocationHandler cih = new CustomInvocationHandler(original);

        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(cl,interfaces,cih);
    }







}
