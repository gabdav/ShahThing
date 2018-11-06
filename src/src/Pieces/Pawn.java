package Pieces;

import Game.Blank;
import Game.Board;
import Game.Square;
import Games.Chess;

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
        else{
            moveForwardOne = 1;
        }

        if(Chess.activeGame) {
            if (moveToY == moveFromY + moveForwardOne) {

                //move to take a piece that is of a different color to the diagonally
                if ((moveToX == moveFromX - 1) || (moveToX == moveFromX + 1)) {
                    return (!toSquare.getType().equalsIgnoreCase("blank")) && (!toSquare.getColor().equalsIgnoreCase(plyColor));
                }
                //straight move forward 1 and move is to blank space
                else return (moveToX == moveFromX) && (toSquare.getType().equalsIgnoreCase("blank"));
            }
            return false;
        }else{
            if (moveToY == moveFromY + moveForwardOne && (moveToX >= moveFromX + 1 || moveToX <= moveFromX - 1)) {
                //move to take a piece that is of a different color to the diagonally
                if ((moveToX == moveFromX - 2) || (moveToX == moveFromX + 2)) {
                    if((!toSquare.getType().equalsIgnoreCase("blank")) && (!toSquare.getColor().equalsIgnoreCase(plyColor))){
                        Board.board[moveToY - moveForwardOne][moveToX - ((moveFromX - moveToX)/2)].setType("blank");
                        return true;
                    }else{
                        return false;
                    }
                }
                //straight move diagonal 1 and move is to blank space
                else return ((moveToX == moveFromX + 1 || moveToX == moveFromX - 1) && (moveToY == moveFromY + moveForwardOne) && (toSquare.getType().equalsIgnoreCase("blank")));
            }
            return false;
        }
    }
}
