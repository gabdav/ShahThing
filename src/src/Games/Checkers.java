package Games;

import Game.*;

import Pieces.Pawn;


public class Checkers implements Game {
    @Override
    public void setupBoard() {

        for(int i = 0; i <= 2; i++){
            for (int j = 0; j < 8; j=j+2) {
                if(i == 1 && j == 0) {
                    j=j+1;
                }
                Board.board[i][j] = new Pawn("black");
            }
        }

        for(int i = 0; i < 3; i++){
            for (int j = 1; j < 8; j=j+2) {
                if(i == 1 && j == 1) {
                    j=j-1;
                }
                Board.board[i][j] = new Pawn("blank");
            }
        }

        for(int i = 3; i < 5; i++){
            for(int j = 0; j < 8; j++){
                Board.board[i][j] = new Blank();
            }
        }

        for(int i = 5; i < 8; i++){
            for (int j = 0; j < 8; j=j+2) {
                if(i == 6 && j == 0) {
                    j=j + 1;
                }
                Board.board[i][j] = new Pawn("blank");
            }
        }

        for(int i = 5; i < 8; i++){
            for (int j = 0; j < 8; j=j+2) {
                if(i == 6 && j == 0) {
                    j=j+1;
                }
                Board.board[i][j] = new Pawn("white");
            }
        }
    }
}
