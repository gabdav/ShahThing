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

        Square toSquare = Board.board[moveToY][moveToX];

        String direction;
        String type; //diagonal or straight

        if(moveToY == moveFromY){ //setting all possible move directions
            if(moveToX > moveFromX){
                direction = "rite";
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
                direction = "topRite";
                type = "diagonal";
            }
            else{
                direction = "botRite";
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

                if(direction.equalsIgnoreCase("topRite")){
                    testSquare = Board.board[moveFromY - diagMoveAway][moveFromX + diagMoveAway];
                }
                else if(direction.equalsIgnoreCase("botRite")){
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
            if((direction.equalsIgnoreCase("rite")) || (direction.equalsIgnoreCase("left"))){
                int displaceMax = Math.abs(moveToX - moveFromX); //displacement max depending on what the move to values are

                for(int displace = 1; displace <= displaceMax; displace++){ //looping through squares on the rooks path
                    if(direction.equalsIgnoreCase("rite")){
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
                int displaceMax = Math.abs(moveToY - moveFromY); //displacement max depending on what the move to values are

                for(int displace = 1; displace <= displaceMax; displace++){ //looping through squares on the rooks path

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
