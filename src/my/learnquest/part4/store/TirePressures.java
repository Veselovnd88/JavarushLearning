package my.learnquest.part4.store;

public enum TirePressures {
    LF(30,"Left Front"),
    RF(30, "Right Front"),
    LR(31, "Left Rear"),RR(32, "Right Rear");
    int pressure;
    String name;
    private TirePressures(int pressure,String name){
        this.pressure = pressure;
        this.name = name;
    }
    public  void overridePressure(int pressure){
        this.pressure = pressure;
    }
    public int getPressure() {
        return pressure;
    }

    public String getName() {
        return name;
    }
}
