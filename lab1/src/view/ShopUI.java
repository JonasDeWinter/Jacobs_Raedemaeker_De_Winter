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
        shopui.shop.save();
    }

    public static void addProduct(ShopUI shopui) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        if (title.isEmpty())throw new IllegalArgumentException("titel mag niet leeg zijn");

        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");
        if(!type.equals("M") && !type.equals("G"))throw new IllegalArgumentException("Moet G of M zijn");

        if(type.equalsIgnoreCase("M")){
            shopui.shop.addProduct(new Film(title));
        }else{
            shopui.shop.addProduct(new Game(title) );
        }
    }

    public static void showProduct(ShopUI shopui){
        String id = JOptionPane.showInputDialog("Enter the id:");
        int integerid = Integer.parseInt(id);

            JOptionPane.showMessageDialog(null, shopui.shop.showProduct(integerid));

    }

    public static void showPrice(ShopUI shopui){
        String id = JOptionPane.showInputDialog("Enter the id:");
        if (id.isEmpty())throw new IllegalArgumentException("id mag niet leeg zijn");
        int integerid = Integer.parseInt(id);

            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);

            JOptionPane.showMessageDialog(null,shopui.shop.showPrice(integerid, days));

    }
}