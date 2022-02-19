package my.learnquest.part4.store;

public class PrintEnums {

    public static void main(String[] args) {
            TirePressures tp = TirePressures.valueOf("RR");
            tp.overridePressure(40);
        for(TirePressures t: TirePressures.values()){
            System.out.printf("Pressure in %s tyre is %d%n", t.getName(), t.getPressure());
        }
    }
}
