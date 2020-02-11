
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Shop {

    private ArrayList<Product> producten;


    public Shop()
    {
        producten = new ArrayList<Product>();
    }

    public static void main(String[] args) {

        Shop shop = new Shop();

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                addProduct(shop);
            } else if (choice == 2) {
                showProduct(shop);
            } else if (choice == 3){
                showPrice(shop);
            }
        }
    }

    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

        if(type.equalsIgnoreCase("M")){
            shop.producten.add(new Film(title,Integer.parseInt(id)));
        }else if(type.equalsIgnoreCase("G")){
            shop.producten.add(new Game(title,Integer.parseInt(id)) );
        }
    }

    public static void showProduct(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");
        int integerid = Integer.parseInt(id);
        String title = "";
        boolean found = false;
        for(int i = 0; i < shop.producten.size() && !found; i++)
        {
            if(shop.producten.get(i).getId() == integerid)
            {
                title = shop.producten.get(i).getTitle();
                found = true;
            }
        }
        if(found)
        {
            JOptionPane.showMessageDialog(null, title);
        }
    }

    public static void showPrice(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");
        int integerid = Integer.parseInt(id);
        int idx = -1;
        boolean found = false;
        for(int i = 0; i < shop.producten.size() && !found; i++){
            if(shop.producten.get(i).getId() == integerid){
                idx = i;
                found = true;
            }
        }
        if(found){
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, shop.producten.get(idx).getPrice(days));
        }
    }
}