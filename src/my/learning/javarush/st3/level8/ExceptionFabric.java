package my.learning.javarush.st3.level8;

public class ExceptionFabric {

    public static Throwable getException(Enum exception){

        String raw_message = exception.name().toLowerCase().replace("_"," ");
        String message = Character.toUpperCase(raw_message.charAt(0))+
                raw_message.substring(1);
        if (exception==null){
            return new IllegalArgumentException();
        }
        if(exception instanceof ApplicationExceptionMessage){

            System.out.println(IllegalArgumentException.class.getSimpleName());
            return new Exception(message);

        }
        else if( exception instanceof DatabaseExceptionMessage){
            return new RuntimeException(message);
        }
        else if(exception instanceof UserExceptionMessage){
            return new Error(message);
        }
        return new IllegalArgumentException();
    }
}
