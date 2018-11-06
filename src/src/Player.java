import java.util.ArrayList;
import java.util.List;

public class Player {

    private String color;
    private List<Piece> pieces = new ArrayList<>();

    public Player(){

    }

    public List<Piece> getPieces() {
        return pieces;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean checkColor(String color) {
        return color.equalsIgnoreCase("black") || color.equalsIgnoreCase("white");
    }
}
