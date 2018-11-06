public class ChessBoard extends Board {

    @Override
    public void setupBoard() {

        board[0][0] = new Rook("black");
        board[0][1] = new Horse("black");
        board[0][2] = new Bishop("black");
        board[0][3] = new Queen("black");
        board[0][4] = new King("black");
        board[0][5] = new Bishop("black");
        board[0][6] = new Horse("black");
        board[0][7] = new Rook("black");

        for(int i = 0; i < 8; i++){
            board[1][i] = new Pawn("black");
        }

        for(int i = 2; i < 6; i++){ //creating blank spaces in middle
            for(int j = 0; j < 8; j++){
                board[i][j] = new Square("empty");
            }
        }

        for(int i = 0; i < 8; i++){
            board[6][i] = new Pawn("white");
        }

        board[7][0] = new Rook("white");
        board[7][1] = new Horse("white");
        board[7][2] = new Bishop("white");
        board[7][3] = new Queen("white");
        board[7][4] = new King("white");
        board[7][5] = new Bishop("white");
        board[7][6] = new Horse("white");
        board[7][7] = new Rook("white");

    }

}
