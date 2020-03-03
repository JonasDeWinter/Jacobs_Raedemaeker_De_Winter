package View;

import javax.swing.*;

public class FeestMateriaalUi {

    public static void main(String[] args){
        String menu = "1. Add party item\n2. Remove party item\n3. Rent party item\n4. Return party item\n5. Repair party item\n6. Show available party items\n\n0.STOP\n\nMake your shoice:";
        int choice = -1;
        while (choice != 0){
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);

            switch (choice){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    break;
            }
        }

    }
}
