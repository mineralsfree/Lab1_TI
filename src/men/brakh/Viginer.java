package men.brakh;
public class Viginer implements Cipher {
    private String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public Viginer() {
    }
    private String generateKey(String key, int len) {
        StringBuilder progrKey = new StringBuilder(len);

        for (int i = 0; i <= len; i++) {
            int tmp = (alphabet.indexOf(key.charAt(i % (key.length()))) + (i/key.length())) % alphabet.length();
            progrKey.append(alphabet.charAt(tmp));
        }

        return progrKey.toString();
    }
    @Override
    public String encode(String message, String keyword) {
        String progrKey = generateKey(keyword, message.length());
        StringBuilder cipherText = new StringBuilder(message);
        for(int i = 0; i < message.length(); i++) {
            // f(a) = (a + k) mod N
            int charIndex = (alphabet.indexOf(message.charAt(i)) +
                    alphabet.indexOf(progrKey.charAt(i))) % alphabet.length();
            cipherText.setCharAt(i,alphabet.charAt(charIndex));
        }
        return cipherText.toString();
    }
    @Override
    public String decode(String message, String keyword) {
        String progrKey = generateKey(keyword, message.length());
        StringBuilder plaintext = new StringBuilder(message);
        for(int i = 0; i < message.length(); i++) {
            // a = (f(a) + (N-k)) mod N
            int charIndex = (alphabet.indexOf(message.charAt(i)) +
                    (alphabet.length() - alphabet.indexOf(progrKey.charAt(i)))) % alphabet.length();
            plaintext.setCharAt(i,alphabet.charAt(charIndex));
        }
        return plaintext.toString();
    }

}