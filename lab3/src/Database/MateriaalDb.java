package Database;


import Model.Materiaal;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MateriaalDb {
    private Map<Integer, Materiaal> feestArtikelen ;
    private File file = new File("Artikelen.txt");
    public MateriaalDb(){
        feestArtikelen = new HashMap<>();
    }

    public void addItem(Materiaal product, int id){
        for (Materiaal p:feestArtikelen.values()){
            if (p.getNaam().equals(product.getNaam()))throw new IllegalArgumentException("Dit item staat al in de lijst");
        }
        feestArtikelen.put(id,product);
    }

    public void returnProduct(int index,boolean beschadiging){
        if (feestArtikelen.size() != 0){
            for (Map.Entry<Integer, Materiaal> p:feestArtikelen.entrySet()){
                if(p.getKey() == index) {
                    p.getValue().brengTerug(beschadiging);
                }
            }
        }
    }

    public String showProducten(){
        String result = "";
        if (feestArtikelen.size() != 0){
            for (Map.Entry<Integer, Materiaal> p:feestArtikelen.entrySet()){
                if(p.getValue().getCurrentState() == (p.getValue().getUitleenbaar())) {
                    result += p.getKey() + ", " + p.getValue().getNaam() + ", " + p.getValue().getAanschafprijs() + "\n";
                }
            }
        }
        return result;
    }

    public void removeProduct(int id){
        for (Map.Entry<Integer, Materiaal> p:feestArtikelen.entrySet()){
            if(p.getKey() == id){
                p.getValue().verwijder();
                feestArtikelen.remove(id);
            }
        }

    }

    public void rentProduct(int id){
        if (feestArtikelen.size() != 0){
            for (Map.Entry<Integer, Materiaal> p:feestArtikelen.entrySet()){
                if(p.getKey() == id){
                    if(p.getValue().getCurrentState() == (p.getValue().getUitleenbaar())) {
                        p.getValue().leenUit();
                    }
                }
            }
        }
    }

    public void repairItem(int id, boolean herstelbaarheid){
        if (feestArtikelen.size() != 0){
            for (Map.Entry<Integer, Materiaal> p:feestArtikelen.entrySet()){
                if(p.getKey() == id){
                    if(herstelbaarheid){
                        p.getValue().herstel();
                    }else{
                        this.removeProduct(id);
                    }
                }
            }
        }

    }

    public void load(){
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                Scanner scannerline = new Scanner(scanner.nextLine());
                scannerline.useDelimiter(", ");
                String idString = scannerline.next();
                String titel = scannerline.next();
                String prijsString = scannerline.next();
                double prijs = Double.parseDouble(prijsString);
                int id = Integer.parseInt(idString);
                this.addItem(new Materiaal(titel,prijs),id);
            }
        }catch(Exception e){
            throw new IllegalArgumentException("file niet gevonden", e);
        }

    }
    public void save(){

        try{
            PrintWriter writer = new PrintWriter(file);
            for (Map.Entry<Integer, Materiaal> p:feestArtikelen.entrySet()){
                writer.println(p.getKey() + ", " + p.getValue().getNaam() + ", " + p.getValue().getAanschafprijs());
            }
            writer.close();
        }catch (Exception e){
            throw new IllegalArgumentException("file niet gevonden",e);
        }
    }
}
