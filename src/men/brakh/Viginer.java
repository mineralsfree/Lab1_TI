package men.brakh;

public class Viginer implements Cipher {

    @Override
    public String encode(String message, String key) {
        String ret =  "";
        String modkey = getKey(key,message);
        System.out.println(modkey);
        for (int i=0;i<message.length();i++){
            ret+=cipherChar(message.charAt(i),(modkey.charAt(i)-'A'));
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
            char c = (char)(msg.charAt(x) + shift);
            if (c > 'Z')
                s += (char)(msg.charAt(x) - (26-shift));
            else
                s += (char)(msg.charAt(x) + shift);
        }
        return s;
    }
    private char cipherChar(char x, int shift){
        char s = 0;

            char c = (char)(x + shift);
            if (c > 'Z')
                s += (char)(x - (26-shift));
            else
                s += (char)(x + shift);

        return s;
    }

    @Override
    public String decode(String message, String key) {
        return null;
    }
}
