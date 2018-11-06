package Game;

public class Blank extends Square {

    public Blank() {
        super("blank");
        symbol = "#";
        setColor(null);

    }

    public boolean movement(int[] moveFromReq, int[] moveToReq, String plyColor) { //unused
        return false;
    }
}
