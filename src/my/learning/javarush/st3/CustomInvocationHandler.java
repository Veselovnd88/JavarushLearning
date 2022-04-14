package my.learning.javarush.st3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods siwm;

    public CustomInvocationHandler(SomeInterfaceWithMethods siwm){
        this.siwm = siwm;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+" in");//когда метод вызывается  - печатает и вызывает методы у ОРИГИНАЛЬНОГО объекта
        Object result = method.invoke(this.siwm,args);
        System.out.println(method.getName()+" out");


        return result;
    }
    public static void task2(){

    }
}
