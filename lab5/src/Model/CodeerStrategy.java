package Model;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public interface CodeerStrategy {
    String encode(String tekst);
    String decode(String tekst);
}
