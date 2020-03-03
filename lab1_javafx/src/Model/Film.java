package Model;

public class Film extends Product {
    public Film(String title){
        super(title);
    }

    public double getPrice(int dagen){
        double prijs = 5;
        int daysLeft = dagen - 3;
        if (daysLeft > 0) {
            prijs += (daysLeft * 2);
        }
        return prijs;
    }
}
