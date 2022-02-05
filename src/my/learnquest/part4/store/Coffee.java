package my.learnquest.part4.store;

public class Coffee {

    public Coffee(int temp) throws TooHotException {
        super();
        this.setTemperature(temp);
    }
    public Coffee(){}
    private int temperature =0;


    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temp) throws TooHotException{
        if (temp>120){
            throw new TooHotException("is too hot");
        }
        else{
        this.temperature = temp;}
    }
}
