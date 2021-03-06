package Pieces;

import Game.Board;
import Game.Square;

public class Bishop extends Piece {

    public Bishop(String colorIn) {
        super(colorIn, "bishop");

        if(getColor().equalsIgnoreCase("white")){
            setSymbol("B");
        }
        else{
            setSymbol("b");
        }

    }

    @Override
    public boolean movement(int[] moveFromReq, int[] moveToReq, String plyColor) {

        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];

        int moveDistance = Math.abs(moveToX - moveFromX);

        String direction;

        if(moveToX > moveFromX){
            if(moveToY < moveFromY){
                direction = "topRight";
            }
            else{
                direction = "botRight";
            }
        }
        else{
            if(moveToY < moveFromY){
                direction = "topLeft";
            }
            else{
                direction = "botLeft";
            }
        }

        Square testSquare;

        for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++){

            if(direction.equalsIgnoreCase("topRight")){
                testSquare = Board.board[moveFromY - diagMoveAway][moveFromX + diagMoveAway];
            }
            else if(direction.equalsIgnoreCase("botRight")){
                testSquare = Board.board[moveFromY + diagMoveAway][moveFromX + diagMoveAway];
            }
            else if(direction.equalsIgnoreCase("topLeft")){
                testSquare = Board.board[moveFromY - diagMoveAway][moveFromX - diagMoveAway];
            }
            else{
                testSquare = Board.board[moveFromY + diagMoveAway][moveFromX - diagMoveAway];
            }

            if((!testSquare.getType().equalsIgnoreCase("blank")) && (diagMoveAway != moveDistance)){
                return false;
            }
            else if((diagMoveAway == moveDistance) && ((!testSquare.getColor().equalsIgnoreCase(plyColor)) || (testSquare.getType().equalsIgnoreCase("blank")))){
                return true;
            }
        }
        return false;
    }

}
