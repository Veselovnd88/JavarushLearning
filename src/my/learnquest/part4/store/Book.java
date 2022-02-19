package my.learnquest.part4.store;

public class Book {

    public Book(){
        this(null,null,0,0,null);
    }
    public Book(String title, String author, double price, int qnt, String cat){
        setTitle(title);
        setAuthor(author);
        setPrice(price);
        setQuantity(qnt);
        setCategory(cat);
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    private String title;
private String author;
private double price;
private int quantity;
private String category;
}
