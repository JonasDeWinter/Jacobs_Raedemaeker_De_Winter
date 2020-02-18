package Database;

import Model.Product;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        producten.put(intId,product);
    }

    public Product showProduct(int index){

        return producten.get(index);
    }

    public void save(){
        File file = new File("Shop.txt");

        try{
            PrintWriter writer = new PrintWriter(file);

            for (Product p:producten.values()){
                writer.println(p.getTitle() +", " + p.getClass().getSimpleName());
            }
        }catch (Exception e){
            throw new IllegalArgumentException("file niet gevonden",e);
        }
    }
}
