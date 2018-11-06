import Games.Checkers;
import Game.*;
import Game.Player;
import Games.Chess;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    //prevName value can be set to null if this is the first call
    private static String getName(int playerNum, String prevName){
        String name;

        while(true){
            System.out.print("Player " + playerNum + " please enter your name.\n>> ");
            name = scanner.nextLine().trim();

            //if there is no spaces and it is not empty and names are not the same
            if(!name.isEmpty() && !(name.contains(" ") || name.contains("\t")) && !name.equals(prevName))

                break; //otherwise the user will be asked to enter again
            else
                System.out.println("Invalid name. Try again.");
        }
        return name;
    }
    public static void main(String[] args){

        System.out.println("=====> CHESS <====="); //title

        String ply1Name = getName(1, null);
        String ply2Name = getName(2, ply1Name);

        Player whitePly = new Player(ply1Name, "white");
        Player blackPly = new Player(ply2Name, "black");

        Game game = new Chess();
        game.setupBoard();

        //start main loop
        while(true){

            for(int runNum = 1; runNum <= 2; runNum++){ //run for each player
                Board.draw();
                int move[][];

                while(true){

                    if(runNum == 1){ //first run
                        move = whitePly.getMove();
                    }
                    else{ //second run
                        move = blackPly.getMove();
                    }

                    if(move[0][0] == -1){ //restarting loop if input is wrong
                        System.out.println("Invalid location. Try again.");
                        continue;
                    }

                    int[] moveFrom = move[0];
                    int[] moveTo = move[1];
                    Square fromSquare = Board.board[moveFrom[1]][moveFrom[0]];

                    boolean checkValue;
                    if(runNum == 1){
                        checkValue = fromSquare.movement(moveFrom, moveTo, "white"); //checking for pawn move validity
                    }
                    else{
                        checkValue = fromSquare.movement(moveFrom, moveTo, "black");
                    }
                    if(checkValue){
                        Board.update(moveFrom,moveTo);
                        break;
                    }
                    System.out.println("Invalid move. Try again."); //not printed if break is called
                }
            }
        }
    }
}
