package model;

public class HoofdletterDecorator extends FileLetterLezerDecorator {
    private char vorigeLetter = ' ';

    public HoofdletterDecorator(LetterLezer letterLezer){
        super(letterLezer);
    }

    public char leesLetter(){
        char letter = ' ';
        if (vorigeLetter == ' '){
            letter = Character.toUpperCase(getLetterLezer().leesLetter());
        }else{
            letter = getLetterLezer().leesLetter();
        }
        vorigeLetter = letter;
        return letter;
    }
}
