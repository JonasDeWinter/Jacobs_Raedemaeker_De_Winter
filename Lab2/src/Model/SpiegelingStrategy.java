package Model;

public class SpiegelingStrategy implements CodeerStrategy{
    @Override
    public String encode(String tekst) {
        String result = "";
        for (int i = tekst.length() - 1; i >= 0; i--){
            result += tekst.charAt(i);
        }
        return result;
    }

    @Override
    public String decode(String tekst) {
        String result = "";
        for (int i = tekst.length() - 1; i >= 0; i--){
            result += tekst.charAt(i);
        }
        return result;
    }
}
