package Pieces;

import Game.Board;
import Game.Square;

public class Pawn extends Piece {

    public Pawn(String colorIn) {
        super(colorIn, "pawn");

        if(getColor().equalsIgnoreCase("white")){
            setSymbol("P");
        }
        else{
            setSymbol("p");
        }
    }

    @Override
    public boolean movement(int[] moveFromReq, int[] moveToReq, String plyColor) {

        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];

        int moveForwardOne;

        Square toSquare = Board.board[moveToY][moveToX];

        if(plyColor.equalsIgnoreCase("white")){ //for white pieces direction changes
            moveForwardOne = -1;
        }
        else{ //black
            moveForwardOne = 1;
        }

        if(moveToY == moveFromY + moveForwardOne){

            //move to take a piece that is of a different color to the diagonally
            if((moveToX == moveFromX - 1) || (moveToX == moveFromX + 1)){
                return (!toSquare.getType().equalsIgnoreCase("blank")) && (!toSquare.getColor().equalsIgnoreCase(plyColor));
            }
            //straight move forward 1 and move is to blank space
            else return (moveToX == moveFromX) && (toSquare.getType().equalsIgnoreCase("blank"));
        }
        return false; //only get here if other possiblities fail
    }
}
