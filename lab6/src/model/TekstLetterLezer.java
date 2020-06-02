package model;

public class TekstLetterLezer implements LetterLezer{
    private String tekst;
    private int index = 0;

    public TekstLetterLezer(String tekst){
        this.tekst = tekst;
    }

    public char leesLetter(){
        if (index < tekst.length()){
            return tekst.charAt(index++);
        }
        return '*';
    }
}
