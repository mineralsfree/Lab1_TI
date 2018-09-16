package men.brakh;

public class RailWay implements Cipher{
	private int getDelta(int pos, int row, int key) {
        if ((key == 0) || (key == 1)) {
            return 1;
        }
        if((row == 0) || (row == key-1)) {
            return (key-1)*2;
        }

        if (pos % 2 == 0) { 
            return (key-1-row)*2;
        }
        return 2*row;
	}
	@Override
	public String encode(String message, int key) {
		String encodedString ="";
		for (int row =0;row<key;row++) {
			int num=0;
			for (int i=row;i<message.length();i+=getDelta(num++,row,key)) {
				 encodedString += message.charAt(i);
				
				
				
			}
		}
		return encodedString ;

	}

	@Override
	public String decode(String message, int key) {
		int pos =0;
		StringBuilder decodedString = new StringBuilder(message);
		for (int row = 0;row<key;row++) {
			int num = 0;
			for (int i=row;i<message.length();i+=getDelta(num++,row,key)) {
				decodedString.setCharAt(i, message.charAt(pos++));
			}
		}
		
		return decodedString.toString();
	}


		
		

	}
