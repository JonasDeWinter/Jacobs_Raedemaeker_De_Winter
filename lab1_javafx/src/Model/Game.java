package Model;

public class Game extends Product {
    private double prijs = 3;
    public Game(String title){
        super(title);
    }

    public double getPrice(int dagen){
        return prijs * dagen;
    }
}
