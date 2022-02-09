package my.learnquest.part4.store;

public class CoffeeExercise {
    public static void main(String[] args) {
        Coffee cup1 = new Coffee();
        try {
            cup1 = new Coffee(121   );
        } catch (TooHotException e) {
            System.out.println(e.getMessage());
        }
        finally{
        System.out.println("Coffee is set to "+ cup1.getTemperature());}

    }
}
