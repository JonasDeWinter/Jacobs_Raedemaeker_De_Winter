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
        System.out.println(tekst);
        System.out.println(strategy);
        String string = strategy.encode(tekst);
        System.out.println(string);
        return strategy.encode(tekst);
    }

    public String decode(String tekst) {
        return strategy.decode(tekst);
    }
}
