package model;

public class SpatieWegDecorator extends FileLetterLezerDecorator{

    public SpatieWegDecorator(LetterLezer letterLezer){
        super(letterLezer);
    }

    public char leesLetter(){
        char tekst = getLetterLezer().leesLetter();
        while (tekst == ' ' && tekst !='*'){
            tekst = getLetterLezer().leesLetter();
        }
        return tekst;
    }
}
