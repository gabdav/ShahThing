package Game;

public abstract class Square {
    protected String symbol;
    private String color;
    private String type;


    public Square(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getSymbol() {

        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public abstract boolean movement(int[] moveFromReq, int[] moveToReq, String plyColor);

}
