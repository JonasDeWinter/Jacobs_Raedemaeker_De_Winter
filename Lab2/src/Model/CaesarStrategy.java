package Model;

public class CaesarStrategy implements CodeerStrategy{
    private String alfabet = "abcdefghijklmnopqrstuvwxyz";
    private int offset;
    @Override
    public String encode(String tekst){

        String uitkomst = "";
        tekst = tekst.toLowerCase();
        for(int i = 0; i< tekst.length(); i++){

            for(int j = 0; j< alfabet.length(); j++){
                if(tekst.charAt(i) == (alfabet.charAt(j))){
                    if(j-3<0){
                        uitkomst += alfabet.charAt(26+(j-3));
                    }else {
                        uitkomst += alfabet.charAt(j - 3);
                    }
                }

            }
            String s = String.valueOf(tekst.charAt(i));
            if(!alfabet.contains(s)){
                uitkomst += s;
            }
        }

        return uitkomst;
    }

    @Override
    public String decode(String tekst){
        String uitkomst = "";
        tekst = tekst.toLowerCase();
        for(int i = 0; i< tekst.length(); i++){

            for(int j = 0; j< alfabet.length(); j++){
                if(tekst.charAt(i) == (alfabet.charAt(j))){
                    if(j+3>25){
                        uitkomst += alfabet.charAt((j+3)-26);
                    }else {
                        uitkomst += alfabet.charAt(j + 3);
                    }
                }

            }
            String s = String.valueOf(tekst.charAt(i));
            if(!alfabet.contains(s)){
                uitkomst += s;
            }
        }
        System.out.println(uitkomst);
        return uitkomst;
    }
}
