package men.brakh;

public interface Cipher {
		String encode(String message, String key);
		String decode(String message, String key);
}
