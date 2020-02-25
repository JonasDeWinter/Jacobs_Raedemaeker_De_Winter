import javax.swing.*;

public class CodeerStrategyUI {


    public static void main(String[] args) {
        String tekst = JOptionPane.showInputDialog("de tekst die je wilt coderen/decoderen");
        String codeerStrategy = JOptionPane.showInputDialog("1. Caesar\n2. Spiegeling");
        int codeerint = Integer.parseInt(codeerStrategy);
        CodeerContext context = new CodeerContext(tekst,new CaesarStrategy());
        context.encode(tekst);


    }
}
