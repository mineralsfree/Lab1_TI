package men.brakh;

public class Viginer implements Cipher {
    public static String alphabet  ="АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    @Override
    public String encode(String message, String key) {
        String ret =  "";
        String modkey = getKey(key,message);
        System.out.println(modkey);
        for (int i=0;i<message.length();i++){
            ret+=cipherChar(message.charAt(i),(alphabet.indexOf(modkey.charAt(i))));
        }
        return ret;
    }

    private String getKey(String key,String msg) {
        String ret ="";
        int a =0;
        while (ret.length()<msg.length()){
            ret+=cipher(key, a);
            a++;
        }
        return ret;
    }

    private String cipher(String msg, int shift){
        String s = "";
        int len = msg.length();
        for(int x = 0; x < len; x++){
            char c = alphabet.charAt((alphabet.indexOf(msg.charAt(x))+ shift)%alphabet.length());
               s += c;
        }
        return s;
    }
    private char cipherChar(char x, int shift){
        return alphabet.charAt((alphabet.indexOf(x)+ shift)%alphabet.length());
    }

    @Override
    public String decode(String message, String key) {
        return null;
    }
}
