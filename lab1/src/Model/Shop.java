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


}
