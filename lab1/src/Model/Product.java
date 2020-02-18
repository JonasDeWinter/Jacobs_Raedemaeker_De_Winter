package Model;

public abstract class Product {
    private String title;
    public Product(String title){
        this.title = title;
    }


    public String getTitle(){
        return title;
    }

    public abstract double getPrice(int dagen);
}
