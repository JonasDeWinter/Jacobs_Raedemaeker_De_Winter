public class Film extends Product {
    private  double prijs = 5;
    public Film(String title, int id){
        super(title, id);
    }

    public double getPrice(int dagen){
        int daysLeft = dagen - 3;
        if (daysLeft > 0) {
            prijs += (daysLeft * 2);
        }
        return prijs;
    }
}
