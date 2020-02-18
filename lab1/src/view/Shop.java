package view;

import Model.Film;
import Model.Game;
import Model.Product;

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
        for (Product p:shop.producten){
            if (p.getTitle().equals(title))throw new IllegalArgumentException("Dit item staat al in de lijst");
        }
        //String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");
        if(!type.equals("M") && !type.equals("G"))throw new IllegalArgumentException("Moet G of M zijn");

        int intId = shop.producten.size()+1;

        if(type.equalsIgnoreCase("M")){
            shop.producten.add(new Film(title,intId));
        }else if(type.equalsIgnoreCase("G")){
            shop.producten.add(new Game(title,intId) );
        }
    }

    public static void showProduct(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");
        int integerid = Integer.parseInt(id);
        String title = "";
        boolean found = false;
        if (integerid > shop.producten.size() || integerid < 0)throw new IllegalArgumentException("dit is een fout id");
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
        if (id.isEmpty())throw new IllegalArgumentException("id mag niet leeg zijn");
        int integerid = Integer.parseInt(id);
        if (integerid > shop.producten.size() || integerid < 0)throw new IllegalArgumentException("dit is een fout id");

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
            if (days < 0)throw new IllegalArgumentException("mag niet kleinder dan 0 zijn");
            JOptionPane.showMessageDialog(null, shop.producten.get(idx).getPrice(days));
        }
    }
}