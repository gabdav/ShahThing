package Pieces;

import Game.Square;

public abstract class Piece extends Square {

    public Piece getPiece(){
        return this;
    }
    public Piece(String color, String typeIn) {
        super(typeIn);
        setColor(color);
    }
    public abstract boolean movement(int[] moveFromReq, int[] moveToReq, String plyColor);
}
