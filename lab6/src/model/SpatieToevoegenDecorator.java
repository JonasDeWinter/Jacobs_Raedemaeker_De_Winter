package model;

public class SpatieToevoegenDecorator extends FileLetterLezerDecorator{
    private char vorigeLetter = ' ';

    public SpatieToevoegenDecorator(LetterLezer letterLezer){
        super(letterLezer);
    }

    public char leesLetter(){
        char letter = ' ';

        if (vorigeLetter == ' '){
            letter = getLetterLezer().leesLetter();
        }else{
            letter = ' ';
        }
        vorigeLetter = letter;
        return letter;
    }
}
