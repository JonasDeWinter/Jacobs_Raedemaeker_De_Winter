package View;

import Model.CaesarStrategy;
import Model.CodeerContext;
import Model.SpiegelingStrategy;

import javax.swing.*;

public class CodeerStrategyUI {


    public static void main(String[] args) {
        int choise = -1;
        while (choise != 0){
            String tekst = JOptionPane.showInputDialog("de tekst die je wilt coderen/decoderen");
            String codeerStrategy = JOptionPane.showInputDialog("1. Caesar\n2. Spiegeling");
            CodeerContext context;

            if (codeerStrategy.equalsIgnoreCase("1")){
                context = new CodeerContext(tekst,new CaesarStrategy());
            }else if(codeerStrategy.equalsIgnoreCase("2")){
                context = new CodeerContext(tekst,new SpiegelingStrategy());
            }else{
                return;
            }

            String codeerOfEncodeer = JOptionPane.showInputDialog("e. Encodeer\nd. Decodeer");
            if (codeerOfEncodeer.equalsIgnoreCase("e")){
                context.encode(tekst);
                System.out.println(context.encode(tekst));
            }else if (codeerOfEncodeer.equalsIgnoreCase("d")){
                context.decode(tekst);
                System.out.println(context.decode(tekst));
            }
        }
    }
}
