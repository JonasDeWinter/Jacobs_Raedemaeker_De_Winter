package Database;

import Model.Film;
import Model.Game;
import Model.Product;

import java.io.File;
import java.io.PrintWriter;
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
                    producten.put(intId,new Game(titel));
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
