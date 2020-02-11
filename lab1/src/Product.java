public abstract class Product {
    private String title;
    private int id;
    public Product(String title, int id){
        this.title = title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }
    abstract double getPrice(int dagen);
}
