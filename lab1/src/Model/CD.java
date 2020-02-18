package Model;

public class CD extends Product{
    private double prijs = 1.5;

    public CD(String title){
        super(title);
    }

    public double getPrice(int dagen){
        return prijs * dagen;
    }
}
