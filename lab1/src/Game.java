public class Game extends Product {
    private double prijs = 3;
    public Game(String title, int id){
        super(title, id);
    }

    public double getPrice(int dagen){
        return prijs * dagen;
    }
}
