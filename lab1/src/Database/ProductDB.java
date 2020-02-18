package Database;

import Model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDB {
    private Map<Integer, Product> producten ;

    public ProductDB(){
        producten = new HashMap<>();
    }

    public void addProduct(Product product){
        for (Product p:producten.values()){
            if (p.getTitle().equals(product.getTitle()))throw new IllegalArgumentException("Dit item staat al in de lijst");
        }
        int intId = producten.size()+1;
    }
}
