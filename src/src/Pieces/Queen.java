package Pieces;

import Game.Board;
import Game.Square;

public class Queen extends Piece {

    public Queen(String colorIn) {
        super(colorIn, "queen");

        if(getColor().equalsIgnoreCase("white")){
            setSymbol("Q");
        }
        else{
            setSymbol("q");
        }
    }

    @Override
    public boolean movement(int[] moveFromReq, int[] moveToReq, String plyColor) {

        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];

        String direction;
        String type; //diagonal or straight

        if(moveToY == moveFromY){
            if(moveToX > moveFromX){
                direction = "right";
                type = "straight";
            }
            else{
                direction = "left";
                type = "straight";
            }
        }

        else if(moveToX == moveFromX){
            if(moveToY > moveFromY){
                direction = "bot";
                type = "straight";
            }
            else{
                direction = "top";
                type = "straight";
            }
        }
        else if(moveToX > moveFromX){
            if(moveToY < moveFromY){
                direction = "topRight";
                type = "diagonal";
            }
            else{
                direction = "botRight";
                type = "diagonal";
            }
        }
        else if(moveToX < moveFromX){
            if(moveToY < moveFromY){
                direction = "topLeft";
                type = "diagonal";
            }
            else{
                direction = "botLeft";
                type = "diagonal";
            }
        }
        else{
            return false;
        }

        Square testSquare;

        if(type.equalsIgnoreCase("diagonal")){
            int moveDistance = Math.abs(moveToX - moveFromX);

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
                else{ //botLeft
                    testSquare = Board.board[moveFromY + diagMoveAway][moveFromX - diagMoveAway];
                }

                if((!testSquare.getType().equalsIgnoreCase("blank")) && (diagMoveAway != moveDistance)){
                    return false;
                }
                else if((diagMoveAway == moveDistance) && ((!testSquare.getColor().equalsIgnoreCase(plyColor)) || (testSquare.getType().equalsIgnoreCase("blank")))){
                    return true;
                }
            }
        }
        else{ //straight
            if((direction.equalsIgnoreCase("right")) || (direction.equalsIgnoreCase("left"))){
                int displaceMax = Math.abs(moveToX - moveFromX);

                for(int displace = 1; displace <= displaceMax; displace++){
                    if(direction.equalsIgnoreCase("right")){
                        testSquare = Board.board[moveFromY][moveFromX + displace];

                        if((!testSquare.getType().equalsIgnoreCase("blank")) && (displace != displaceMax)){
                            return false;
                        }
                        else if((displace == displaceMax) && ((testSquare.getType().equalsIgnoreCase("blank")) || (!testSquare.getColor().equalsIgnoreCase(plyColor)))){
                            return true;
                        }
                    }
                    else{
                        testSquare = Board.board[moveFromY][moveFromX - displace];

                        if((!testSquare.getType().equalsIgnoreCase("blank")) && (displace != displaceMax)){
                            return false;
                        }
                        else if((displace == displaceMax) && ((testSquare.getType().equalsIgnoreCase("blank")) || (!testSquare.getColor().equalsIgnoreCase(plyColor)))){
                            return true;
                        }
                    }
                }
            }
            else{ // direction : top or bot
                int displaceMax = Math.abs(moveToY - moveFromY);

                for(int displace = 1; displace <= displaceMax; displace++){

                    if(direction.equalsIgnoreCase("top")){
                        testSquare = Board.board[moveFromY - displace][moveFromX];

                        if((!testSquare.getType().equalsIgnoreCase("blank")) && (displace != displaceMax)){
                            return false;
                        }
                        else if((displace == displaceMax) && ((testSquare.getType().equalsIgnoreCase("blank")) || (!testSquare.getColor().equalsIgnoreCase(plyColor)))){
                            return true;
                        }
                    }
                    else{
                        testSquare = Board.board[moveFromY + displace][moveFromX];

                        if((!testSquare.getType().equalsIgnoreCase("blank")) && (displace != displaceMax)){
                            return false;
                        }
                        else if((displace == displaceMax) && ((testSquare.getType().equalsIgnoreCase("blank")) || (!testSquare.getColor().equalsIgnoreCase(plyColor)))){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
