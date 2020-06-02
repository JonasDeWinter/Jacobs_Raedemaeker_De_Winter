package view;

import model.FileLetterLezer;
import model.HoofdletterDecorator;
import model.LetterLezer;
import model.SpatieToevoegenDecorator;

public class FileLetterLezerLauncher {
    public static void main(String[] args) {
        LetterLezer fl = new FileLetterLezer("letters.txt");
        fl = new HoofdletterDecorator(fl);
        fl = new SpatieToevoegenDecorator(fl);
        char letter = fl.leesLetter();
        while (letter != '*') {
            System.out.print(letter);
            letter = fl.leesLetter();
        }
    }
}
