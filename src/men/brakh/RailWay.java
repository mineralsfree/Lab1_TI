package men.brakh;

/**
 * Class Allows you to encrypt and decrypt messages using a cipher "rail-fence"
 * About cipher: https://en.wikipedia.org/wiki/Rail_fence_cipher
 * @author  Pankratiew Alexandr
 * @version  1.0
 */
public class RailWay implements Cipher  {


	private int getTerm(int iteration, int row, int size) {
		if ((size == 0) || (size == 1)) {
			return 1;
		}
		if((row == 0) || (row == size-1)) { // Max. distance is achieved at the ends and equally (size-1)*2
			return (size-1)*2;
		}

		if (iteration % 2 == 0) { // In the description of the method above this identity is demonstrated
			return (size-1-row)*2;
		}
		return 2*row;
	}


	public String encode(String message, int key) {
		if (key < 0) {
			throw new ArithmeticException("Negative key value");
		} else if (key == 0) {
			key = 1;
		}
		String encodedMessage = "";

		for(int row = 0; row < key; row++) { // Look rows
			int iter = 0; // The number of the character in the row
			for(int i = row; i < message.length(); i += getTerm(iter++, row, key)) {
				// i - the number of row character in source line

				encodedMessage += message.charAt(i); // "Add characters line by row"
			}


		}
		return encodedMessage;
	}



	public String decode(String message, int key) {
		if (key < 0) {
			throw new ArithmeticException("Negative key value");
		}
		StringBuilder decodedMessage = new StringBuilder(message);
		int currPosition = 0; // Position in source string
		for(int row = 0; row < key; row++) { // Look rows
			int iter = 0; // The number of the character in the row
			for(int i = row; i < message.length(); i += getTerm(iter++, row, key)) {
				decodedMessage.setCharAt(i, message.charAt(currPosition++));
			}


		}

		return decodedMessage.toString();
	}

	@Override
	public String encode(String message, String key) {
		return encode(message, Integer.parseInt(key));
	}

	@Override
	public String decode(String message, String key) {
		return decode(message, Integer.parseInt(key));
	}
}