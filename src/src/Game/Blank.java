package Game;

public class Blank extends Square {

    public Blank() {
        super("blank");
        symbol = "#";
        setColor(null); //a blank square has no color

    }

    public void move(int[] moveToLoc) {
    }

    public boolean movement(int[] moveFromReq, int[] moveToReq, String plyColor) { //unused
        return false;
    }
}
