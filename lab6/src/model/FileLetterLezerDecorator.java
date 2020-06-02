package model;

public abstract class FileLetterLezerDecorator implements LetterLezer{
    private LetterLezer letterLezer;

    public FileLetterLezerDecorator(LetterLezer letterLezer){
        this.letterLezer = letterLezer;
    }

    public LetterLezer getLetterLezer() {
        return letterLezer;
    }
}
