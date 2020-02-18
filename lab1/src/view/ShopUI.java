package view;

import Model.Film;
import Model.Game;
import Model.Product;
import Model.Shop;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class ShopUI {

    private ArrayList<Product> producten;
    private Shop shop;

    public ShopUI()
    {
        shop =  new Shop();

    }

    public static void main(String[] args) {

        ShopUI shopui = new ShopUI();

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                addProduct(shopui);
            } else if (choice == 2) {
                showProduct(shopui);
            } else if (choice == 3){
                showPrice(shopui);
            }
        }
    }

    public static void addProduct(ShopUI shopui) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        for (Product p:shopui.producten){
            if (p.getTitle().equals(title))throw new IllegalArgumentException("Dit item staat al in de lijst");
        }
        //String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");
        if(!type.equals("M") && !type.equals("G"))throw new IllegalArgumentException("Moet G of M zijn");

        int intId = shopui.producten.size()+1;

        if(type.equalsIgnoreCase("M")){
            shopui.producten.add(new Film(title,intId));
        }else if(type.equalsIgnoreCase("G")){
            shopui.producten.add(new Game(title,intId) );
        }
    }

    public static void showProduct(ShopUI shopui){
        String id = JOptionPane.showInputDialog("Enter the id:");
        int integerid = Integer.parseInt(id);
        String title = "";
        boolean found = false;
        if (integerid > shopui.producten.size() || integerid < 0)throw new IllegalArgumentException("dit is een fout id");
        for(int i = 0; i < shopui.producten.size() && !found; i++)
        {
            if(shopui.producten.get(i).getId() == integerid)
            {
                title = shopui.producten.get(i).getTitle();
                found = true;
            }
        }
        if(found)
        {
            JOptionPane.showMessageDialog(null, title);
        }
    }

    public static void showPrice(ShopUI shopui){
        String id = JOptionPane.showInputDialog("Enter the id:");
        if (id.isEmpty())throw new IllegalArgumentException("id mag niet leeg zijn");
        int integerid = Integer.parseInt(id);
        if (integerid > shopui.producten.size() || integerid < 0)throw new IllegalArgumentException("dit is een fout id");

        int idx = -1;
        boolean found = false;
        for(int i = 0; i < shopui.producten.size() && !found; i++){
            if(shopui.producten.get(i).getId() == integerid){
                idx = i;
                found = true;
            }
        }
        if(found){
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            if (days < 0)throw new IllegalArgumentException("mag niet kleinder dan 0 zijn");
            JOptionPane.showMessageDialog(null, shopui.producten.get(idx).getPrice(days));
        }
    }
}