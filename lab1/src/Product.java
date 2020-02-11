public abstract class Product {
    private String title;
    private int id;
    public Product(String title, int id){
        this.title = title;
        this.id = id;
    }
    abstract double getPrice(int dagen);
}
