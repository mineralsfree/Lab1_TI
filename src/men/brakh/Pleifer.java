package men.brakh;

public class Pleifer implements Cipher{
    public static int  ARRSIZE = 5;
    public char keyArray[][] = new char[ARRSIZE][ARRSIZE];
    public String keyInLine = "CRYPTOGAHBDEFIKLMNQSUVWXZ";

    public void Fillarr(char[][] arr){
        int k =0;
    for (int i=0;i<ARRSIZE;i++){
        for (int j=0;j<ARRSIZE;j++){

            arr[i][j] = keyInLine.charAt(k);
            k++;
        }

    }
    }

    @Override
    public String encode(String message, String key) {
        Fillarr(keyArray);
        String encodedString ="";
        if (message.length()%2 !=0) {
            message = message + "X";
        }
        for (int i=0; i<message.length();i+=2){
            encodedString+=getEncodedPair(message.charAt(i),message.charAt(i+1));
    }

        return encodedString;
    }
    private Coordinates GetCharCoordinates(char c){
        if (c=='J') c='I';
        for (int i=0;i<ARRSIZE;i++){
            for (int j=0;j<ARRSIZE;j++){

                if (keyArray[i][j]==c){
                    return (new Coordinates(i,j));
                }
            }

        }
        return null;
    }
    private char getChar(Coordinates coord){
        return keyArray[coord.getI()][coord.getJ()];
    }
    private String getEncodedPair(char first, char second) {
        String ret = "";
        int i1 = GetCharCoordinates(first).getI();
        int j1 = GetCharCoordinates(first).getJ();
        int i2 = GetCharCoordinates(second).getI();
        int j2 = GetCharCoordinates(second).getJ();
        if ((j1==j2)&&(i1!=i2)){
            ret += getChar(new Coordinates((i1+1)%(ARRSIZE-1),j1));
            ret +=(getChar(new Coordinates((i2+1)%(ARRSIZE-1),j2)));
            return ret;
        }
        if ((i1 ==i2 )&&(j1!=j2)){
            ret += getChar(new Coordinates((i1),(j1+1)%(ARRSIZE-1)));
            ret +=(getChar(new Coordinates((i2),(j2+1)%(ARRSIZE-1))));
            return ret;
        }
        if ((i1!=i2)&&(j2!=j1)){
            ret += getChar(new Coordinates((i1),(j2)));
            ret +=(getChar(new Coordinates((i2),(j1))));
            return ret;
        }
        if ((i1==i2)&&(j1==j2)){
            return getEncodedPair(first,'X');

        }else System.out.print("looooooool");
        return null;
    }


    @Override
    public String decode(String message, String key) {
        Fillarr(keyArray);
        String decodedString ="";
        if (message.length()%2 !=0) {
            message = message + "X";
        }
        for (int i=0; i<message.length();i+=2){
            decodedString+=getDecodedPair(message.charAt(i),message.charAt(i+1));
        }

        return decodedString;
    }
    public class Coordinates{
        private int i;
        private int j;
        public Coordinates(int i,int j){
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }
    private String getDecodedPair(char first, char second) {
        String ret = "";
        int i1 = GetCharCoordinates(first).getI();
        int j1 = GetCharCoordinates(first).getJ();
        int i2 = GetCharCoordinates(second).getI();
        int j2 = GetCharCoordinates(second).getJ();
        if ((j1==j2)&&(i1!=i2)){
            ret += getChar(new Coordinates((i1-1+ARRSIZE)%(ARRSIZE),j1));
            ret +=(getChar(new Coordinates((i2-1+ARRSIZE)%(ARRSIZE),j2)));
            return ret;
        }
        if ((i1 ==i2 )&&(j1!=j2)){
            ret += getChar(new Coordinates((i1),(j1-1+ARRSIZE)%(ARRSIZE)));
            ret +=(getChar(new Coordinates((i2),(j2-1+ARRSIZE)%(ARRSIZE))));
            return ret;
        }

        if ((i1!=i2)&&(j2!=j1)){
            ret += getChar(new Coordinates((i1),(j2)));
            ret +=(getChar(new Coordinates((i2),(j1))));
            return ret;
        }
        if ((i1==i2)&&(j1==j2)){
            return getEncodedPair(first,'X');

        }else System.out.print("looooooool");
        return null;
    }
}
