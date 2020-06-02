package View;
import Database.MateriaalDb;
import Model.Materiaal;
import javax.swing.*;

public class FeestMateriaalUi {

    public static void main(String[] args){
        MateriaalDb data = new MateriaalDb();
        data.load();
        String menu = "1. Add party item\n2. Remove party item\n3. Rent party item\n4. Return party item\n5. Repair party item\n6. Show available party items\n\n0.STOP\n\nMake your shoice:";
        int choice = -1;
        while (choice != 0){
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if(choice == 6){
                showItems(data);
            }else if(choice == 0) {
            }else if (choice == 1) {
                addItem(data);
            }else{
                String idString = JOptionPane.showInputDialog("geef de id van het item");
                int id = Integer.parseInt(idString);
                switch (choice) {
                    case 2:
                        removeItem(id, data);
                        break;
                    case 3:
                        rentItem(id, data);
                        break;
                    case 4:
                        returnItem(id, data);
                        break;
                    case 5:
                        repairItem(id, data);
                        break;
                    default:
                        break;
                }
            }
        }
        data.save();
    }

    private static void addItem(MateriaalDb data){
        String itemnaam = JOptionPane.showInputDialog("geef de naam van het item");
        String AankoopPrijsString = JOptionPane.showInputDialog("geeft de aankoopprijs");
        double aankoopprijs = Double.parseDouble(AankoopPrijsString);
        Materiaal item = new Materiaal(itemnaam,aankoopprijs);
        data.addItem(item);
    }

    private static void removeItem(int id,MateriaalDb data){
        data.removeProduct(id);
    }

    private static void rentItem(int id,MateriaalDb data){
        data.rentProduct(id);
    }

    private static void returnItem(int id,MateriaalDb data){
        String beschadiging = JOptionPane.showInputDialog("is het artikel beschadigd? ja/nee");
        if(beschadiging.equalsIgnoreCase("ja")){
            data.returnProduct(id,true);
        }else{
            data.returnProduct(id,false);
        }
    }

    private static void repairItem(int id,MateriaalDb data){
        String beschadiging = JOptionPane.showInputDialog("is het artikel Herstelbaar? ja/nee");
        if(beschadiging.equalsIgnoreCase("ja")){
            data.repairItem(id,true);
        }else{
            data.repairItem(id,false);
        }
    }

    private static void showItems(MateriaalDb data){
        System.out.println(data.showProducten());
    }
}
