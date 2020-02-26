public class CodeerContext {
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
        return tekst + " " + strategy.encode(tekst);
    }

    public String decode(String tekst) {
        return tekst + " " + strategy.decode(tekst);
    }
}
