package Model;

public class CodeerContext implements CodeerStrategy {
    CodeerStrategy strategy;
    String tekst;

    public CodeerContext(String tekst, CodeerStrategy strategy){
        this.tekst = tekst;
        setStrategy(strategy);
    }

    public String getTekst(){
        return this.tekst;
    }

    public void setStrategy(CodeerStrategy strategy) {
        this.strategy = strategy;
    }

    public String encode(String tekst){
        return tekst + "\n" + strategy.encode(tekst);
    }

    public String decode(String tekst) {
        return tekst + "\n" + strategy.decode(tekst);
    }
}
