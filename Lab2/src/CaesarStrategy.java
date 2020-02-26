public class CaesarStrategy implements CodeerStrategy{
    private String alfabet = "abcdefghijklmnopqrstuvwxyz";
    @Override
    public String encode(String tekst){

        String uitkomst = "";
        tekst = tekst.toLowerCase();
        for(int i = 0; i< tekst.length(); i++){

            for(int j = 0; j< alfabet.length(); j++){
                if(tekst.charAt(i) == (alfabet.charAt(j))){
                    if(j-3<0){
                        uitkomst += alfabet.charAt(25+(j-3));
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
        System.out.println(tekst);
        return" ";
    }
}
