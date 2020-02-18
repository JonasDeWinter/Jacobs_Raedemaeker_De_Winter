package Model;

public class Film extends Product {
    private  double prijs = 5;
    public Film(String title){
        super(title);
    }

    public double getPrice(int dagen){
        int daysLeft = dagen - 3;
        if (daysLeft > 0) {
            prijs += (daysLeft * 2);
        }
        return prijs;
    }
}
