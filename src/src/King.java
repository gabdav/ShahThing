public class King extends Piece {

    public King(String colorIn) {
        super(colorIn, "king");

        if(getColor().equalsIgnoreCase("white")){
            setSymbol("K");
        }
        else{
            setSymbol("k");
        }
    }

    @Override
    public boolean movement(int[] moveFromReq, int[] moveToReq, String plyColor) {

        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];

        Square toSquare = Board.board[moveToY][moveToX];

        for (int moveAwayX = -1; moveAwayX <= 1; moveAwayX++){
            for (int moveAwayY = -1; moveAwayY <= 1; moveAwayY++){
                if(moveToX == moveFromX + moveAwayX && moveToY == moveFromY + moveAwayY){
                    if((!toSquare.getType().equalsIgnoreCase("blank")) && (!toSquare.getColor().equalsIgnoreCase(plyColor))){
                        return true;
                    }
                    else if(toSquare.getType().equalsIgnoreCase("blank")){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
