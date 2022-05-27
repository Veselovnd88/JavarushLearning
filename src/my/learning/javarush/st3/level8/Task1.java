package my.learning.javarush.st3.level8;
/*
Создай класс - фабрику исключений, который содержит один статический метод, возвращающий нужное исключение.
Этот метод должен принимать один параметр - энум.
Если передан энум:
* ApplicationExceptionMessage, верни исключение Exception
* DatabaseExceptionMessage, верни исключение RuntimeException
* UserExceptionMessage, верни Error иначе верни IllegalArgumentException без сообщения.

В качестве сообщения (message) для каждого возвращаемого объекта используй элементы энума, в которых все знаки подчеркивания замени на пробелы. Сообщение должно быть в нижнем регистре за исключением первого символа.
Например, сообщение для ApplicationExceptionMessage.SOCKET_IS_CLOSED - "Socket is closed".

Верни класс созданной фабрики в методе Solution.getFactoryClass.

Энумы не меняй.
* */
public class Task1 {
    public static Class getFactoryClass() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(ExceptionFabric.getException(ApplicationExceptionMessage.SOCKET_IS_CLOSED));

    }
}
