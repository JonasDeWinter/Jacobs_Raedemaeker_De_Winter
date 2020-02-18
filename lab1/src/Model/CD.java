package Model;

public class CD extends Product{
    private double prijs = 1.5;

    public CD(String title, int id){
        super(title, id);
    }

    public double getPrice(int dagen){
        return prijs * dagen;
    }
}
