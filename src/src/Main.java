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
    private static String getGameName(){
        String game;
        while(true){
            System.out.println("Pick a game: Chess or Checkers");
            game = scanner.nextLine().trim();
            if(!game.isEmpty() && !(game.contains(" ") || game.contains("\t")) &&
                    (game.equalsIgnoreCase("Chess") || game.equalsIgnoreCase("Checkers" ))){
                break;
            }else{
                System.out.println("Invalid game. Try again.");
            }
        }
        return game;
    }
    public static void main(String[] args){

        String gameName = getGameName();
        Game game;

        if(gameName.equalsIgnoreCase("Chess")){
            game = new Chess();
            Chess.activeGame = true;
            System.out.println("=====> CHESS <=====");
        }else{
            game = new Checkers();
            System.out.println("=====> CHECKERS <=====");
        }

        String ply1Name = getName(1, null);
        String ply2Name = getName(2, ply1Name);

        Player whitePly = new Player(ply1Name, "white");
        Player blackPly = new Player(ply2Name, "black");

        game.setupBoard();

        System.out.println(game.getClass().getSimpleName());

        while(true){

            for(int runNum = 1; runNum <= 2; runNum++){

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
                    System.out.println("Invalid move. Try again.");
                }
            }
        }
    }
}
