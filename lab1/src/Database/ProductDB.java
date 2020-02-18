package Database;

import Model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDB {
    private Map<Integer, Product> producten ;

    public ProductDB(){
        producten = new HashMap<>();
    }
}
