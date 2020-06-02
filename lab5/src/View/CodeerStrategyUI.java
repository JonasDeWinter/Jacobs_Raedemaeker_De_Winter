package View;

import Model.*;
import Service.CodeerFacade;

import javax.swing.*;

public class CodeerStrategyUI {


    public static void main(String[] args) {
        int choise = -1;
        while (choise != 0){
            String tekst = JOptionPane.showInputDialog("de tekst die je wilt coderen/decoderen");
            String codeerStrategy = JOptionPane.showInputDialog("Caesar\nSpiegeling");


            CodeerStrategy codeerStrategy1 = CodeerFactory.createCodeerStrategy(codeerStrategy);
            CodeerContext context = new CodeerContext(tekst, codeerStrategy1);

            CodeerFacade codeerFacade = new CodeerFacade(context,codeerStrategy1);

            String codeerOfEncodeer = JOptionPane.showInputDialog("e. Encodeer\nd. Decodeer");
            codeerFacade.vertaal(codeerOfEncodeer);

        }
    }
}
