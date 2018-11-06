public class Rook extends Piece{

    public Rook(String colorIn) {
        super(colorIn, "rook");

        if(getColor().equalsIgnoreCase("white")){
            setSymbol("R");
        }
        else{
            setSymbol("r");
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

        if(moveToY == moveFromY){
            if(moveToX > moveFromX){
                direction = "right";
            }
            else{
                direction = "left";
            }
        }

        else if(moveToX == moveFromX){
            if(moveToY > moveFromY){
                direction = "bot";
            }
            else{
                direction = "top";
            }
        }
        else{
            return false;
        }

        Square testSquare;

        if((direction.equalsIgnoreCase("right") ) || (direction.equalsIgnoreCase("left"))){
            int displaceMax = Math.abs(moveToX - moveFromX); //displacement max depending on what the move to values are

            for(int displace = 1; displace <= displaceMax; displace++){ //looping through squares on the rooks path
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

                    if((testSquare.getType().equalsIgnoreCase("blank")) && (displace != displaceMax)){
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
                    else if((displace == displaceMax) && ((testSquare.getType().equalsIgnoreCase("blank") || (!testSquare.getColor().equalsIgnoreCase(plyColor))))){
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
        return false;
    }
}
