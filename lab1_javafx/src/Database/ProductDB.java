package Database;

import Model.CD;
import Model.Film;
import Model.Game;
import Model.Product;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductDB {
    private Map<Integer, Product> producten ;
    private File file = new File("Shop.txt");

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

    public String showProducten(){
        HashMap<Product,Integer>films = new HashMap<>();
        HashMap<Product,Integer>games = new HashMap<>();
        HashMap<Product,Integer>cds = new HashMap<>();
        int teller = 1;

        for(Product p:producten.values()){
            if (p.getClass().getSimpleName().equalsIgnoreCase("Film")){
                films.put(p,teller);
                teller++;
            }else if(p.getClass().getSimpleName().equalsIgnoreCase("Game")){
                games.put(p,teller);
                teller++;
            }else{
                cds.put(p,teller);
                teller++;
            }
        }
        String result = "";
        if (films.size() != 0){
            for (Map.Entry<Product, Integer> p:films.entrySet()){
                result += p.getKey().getTitle() + ", " + p.getKey().getClass().getSimpleName() + ", " + p.getValue() + "\n";
            }
        }
        if (games.size() != 0){
            for (Map.Entry<Product, Integer> p:games.entrySet()){
                result += p.getKey().getTitle() + ", " + p.getKey().getClass().getSimpleName() + ", " + p.getValue() + "\n";
            }
        }
        if (cds.size() != 0){
            for (Map.Entry<Product, Integer> p:cds.entrySet()){
                result += p.getKey().getTitle() + ", " + p.getKey().getClass().getSimpleName() + ", " + p.getValue() + "\n";
            }
        }
        return result;
    }


    public void load(){
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                Scanner scannerline = new Scanner(scanner.nextLine());
                scannerline.useDelimiter(", ");
                String titel = scannerline.next();
                String type = scannerline.next();
                int intId = producten.size()+1;
                if(type.equalsIgnoreCase("Game")){
                    producten.put(intId,new Game(titel));
                }else if(type.equalsIgnoreCase("Film")){
                    producten.put(intId,new Film(titel));
                }
            }
        }catch(Exception e){
            throw new IllegalArgumentException("file niet gevonden", e);
        }

    }
    public void save(){


        try{
            PrintWriter writer = new PrintWriter(file);

            for (Product p:producten.values()){
                writer.println(p.getTitle() +", " + p.getClass().getSimpleName());

            }
            writer.close();
        }catch (Exception e){
            throw new IllegalArgumentException("file niet gevonden",e);
        }
    }
}
