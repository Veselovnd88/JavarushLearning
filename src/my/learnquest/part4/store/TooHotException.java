package my.learnquest.part4.store;

public class TooHotException extends Exception {
    public TooHotException(){
        super();
    }
    public TooHotException(String str){
        super(str);
        //System.out.println(str);
    }
}
