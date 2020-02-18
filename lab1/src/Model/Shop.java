package Model;

import Database.ProductDB;

public class Shop {
    private ProductDB producten;

    public Shop(){
        producten = new ProductDB();
    }

    public void addProduct(Product product){
        producten.addProduct(product);
    }

    public String showProduct(int index){

        producten.showProduct(index);
        return producten.showProduct(index).getTitle();
    }

    public double showPrice(int id, int dagen){
        if (dagen < 0)throw new IllegalArgumentException("mag niet kleinder dan 0 zijn");
        return producten.showProduct(id).getPrice(dagen);
    }

    public void save(){
        producten.save();
    }

    public void load(){
        producten.load();
    }
}
