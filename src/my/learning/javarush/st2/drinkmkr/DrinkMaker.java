package my.learning.javarush.st2.drinkmkr;

public abstract class DrinkMaker {

    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();

    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
