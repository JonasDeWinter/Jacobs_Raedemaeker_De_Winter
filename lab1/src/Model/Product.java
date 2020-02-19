package Model;

public abstract class Product {
    private String title;
    private boolean beschikbaar = true;
    public Product(String title){
        this.title = title;
    }


    public String getTitle(){
        return title;
    }

    public String toString(){
        String result = this.title;
        if (this.beschikbaar == true){
            result += "\n product is beschikbaar";
        }else{
            result += "\n product is onbeschikbaar";
        }
        return result;
    }

    public void wijzigBeschikbaar(Boolean beschikbaar){
        this.beschikbaar = beschikbaar;
    }

    public boolean getBeschikbaar(){
        return this.beschikbaar;
    }

    public abstract double getPrice(int dagen);
}
