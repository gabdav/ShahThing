public class Square {
    private String symbol;
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
}
