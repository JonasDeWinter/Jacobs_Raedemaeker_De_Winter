import javax.swing.*;

public class CodeerStrategyUI {


    public static void main(String[] args) {
        String tekst = JOptionPane.showInputDialog("de tekst die je wilt coderen/decoderen");
        String codeerStrategy = JOptionPane.showInputDialog("1. Caesar\n2. Spiegeling");

        if (codeerStrategy.equalsIgnoreCase("1")){
            CodeerContext context = new CodeerContext(tekst,new CaesarStrategy());
            context.encode(tekst);
        }else if(codeerStrategy.equalsIgnoreCase("2")){
            CodeerContext context = new CodeerContext(tekst,new SpiegelingStrategy());
            context.encode(tekst);
        }
        int codeerint = Integer.parseInt(codeerStrategy);
    }
}
