package Games;

import Game.*;
import Pieces.*;

public class Chess implements Game {
    public static boolean activeGame = false;
    @Override
    public void setupBoard() {


        Board.board[0][0] = new Rook("black");
        Board.board[0][1] = new Horse("black");
        Board.board[0][2] = new Bishop("black");
        Board.board[0][3] = new Queen("black");
        Board.board[0][4] = new King("black");
        Board.board[0][5] = new Bishop("black");
        Board.board[0][6] = new Horse("black");
        Board.board[0][7] = new Rook("black");

        for(int i = 0; i < 8; i++){
            Board.board[1][i] = new Pawn("black");
        }

        for(int i = 2; i < 6; i++){
            for(int j = 0; j < 8; j++){
                Board.board[i][j] = new Blank();
            }
        }

        for(int i = 0; i < 8; i++){
            Board.board[6][i] = new Pawn("white");
        }

        Board.board[7][0] = new Rook("white");
        Board.board[7][1] = new Horse("white");
        Board.board[7][2] = new Bishop("white");
        Board.board[7][3] = new Queen("white");
        Board.board[7][4] = new King("white");
        Board.board[7][5] = new Bishop("white");
        Board.board[7][6] = new Horse("white");
        Board.board[7][7] = new Rook("white");

    }

}
