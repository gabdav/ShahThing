
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

        int moveForwardTwo; //vars that increment the moves | change based on direction
        int moveForwardOne;
        int pawnRowOnPlySide; //row that the certain players pawns are on

        Square toSquare = Board.board[moveToY][moveToX];


        if(plyColor.equalsIgnoreCase("white")){ //for white pieces direction changes
            moveForwardTwo = -2;
            moveForwardOne = -1;
            pawnRowOnPlySide = 6;
        }
        else{ //black
            moveForwardTwo = 2;
            moveForwardOne = 1;
            pawnRowOnPlySide = 1;
        }

        if(moveToY == moveFromY + moveForwardOne){

            //move to take a piece that is of a different color to the diagonally
            if((moveToX == moveFromX - 1) || (moveToX == moveFromX + 1)){
                return (!toSquare.getType().equalsIgnoreCase("blank")) && (!toSquare.getColor().equalsIgnoreCase(plyColor));
            }
            //straight move forward 1 and move is to blank space
            else return (moveToX == moveFromX) && (toSquare.getType().equalsIgnoreCase("blank"));
        }
        //move forward 2 straight and is to blank space
        else if((moveToY == moveFromY + moveForwardTwo) && (moveToX == moveFromX) && (toSquare.getType().equalsIgnoreCase("blank"))){
            return moveFromY == pawnRowOnPlySide;
        }

        return false; //only get here if other possiblities fail
    }
}
