package my.learning.javarush.arrays;

public class Iphone {
    private String model;
    private String color;
    private int price;

    @Override
    public boolean equals(Object obj){
        if(this  == obj){
            return true;
        }
        if(obj ==null){
            return false;
        }
        if(!(obj instanceof Iphone)){
            return false;
        }
        Iphone i = (Iphone) obj;
        if(this.price!=i.price){
            return false;
        }
        if(this.model ==null &&this.color==null){
            return (i.model==null && i.color == null);
        }
        if(this.model==null){
            return (i.model==null && this.color.equals(i.color));
        }
        if(this.color ==null){
            return (i.color==null && this.model.equals(i.model));
        }
        return (this.model.equals(i.model)&&this.color.equals(i.color));
    }

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;

    }
}
