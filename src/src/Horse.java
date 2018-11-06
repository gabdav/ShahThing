public class Horse extends Piece {

    public Horse(String colorIn) {
        super(colorIn, "horse");

        if(getColor().equalsIgnoreCase("white")){
            setSymbol("H");
        }
        else{
            setSymbol("h");
        }
    }

    @Override
    public boolean movement(int[] moveFromReq, int[] moveToReq, String plyColor) {

        int moveFromX = moveFromReq[0];
        int moveFromY = moveFromReq[1];
        int moveToX = moveToReq[0];
        int moveToY = moveToReq[1];

        Square toSquare = Board.board[moveToY][moveToX];

        boolean locationPass = false; //default false

        for (int displaceX = -2; displaceX <= 2; displaceX++) {

            if (displaceX != 0) {
                if (moveToX == moveFromX + displaceX) {

                    if (Math.abs(displaceX) == 1) { //if the x displace was 1 the y displace must be 2
                        for (int displaceY = -2; displaceY <= 2; displaceY += 4) {
                            if (moveToY == moveFromY + displaceY) {
                                locationPass = true;
                            }
                        }
                    } else { //x displace is 2 so y displace is 1
                        for (int displaceY = -1; displaceY <= 1; displaceY += 2) {
                            if (moveToY == moveFromY + displaceY) {
                                locationPass = true;
                            }
                        }
                    }
                }
            }
        }
        //if the location was not within a knights move rules
        return locationPass && ((toSquare.getType().equalsIgnoreCase("blank")) || (toSquare.getColor().equalsIgnoreCase(plyColor)));

    }
}
