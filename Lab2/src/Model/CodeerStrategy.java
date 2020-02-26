package Model;

public interface CodeerStrategy {
    String encode(String tekst);
    String decode(String tekst);
}
