package Game;

import java.util.Scanner;

public class Player {
    private String name;
    private String color;
    private final Scanner scanner = new Scanner(System.in);

    public Player(String nameIn, String colorIn){
        name = nameIn;
        color = colorIn;
    }

    private int convertCharToNum(char charIn){
        int numOut = -1;

        for(int i = 0; i < Board.SIDE_LETTERS.length; i++){

            if(Board.SIDE_LETTERS[i] == charIn){
                numOut = i;
            }
        }
        return numOut;
    }

    private int convertCharNumToNum(char charIn){
        int numOut = -1;
        int convertedNum = Character.getNumericValue(charIn);

        for(int i: Board.SIDE_NUMS){
            if(i == convertedNum){
                numOut = convertedNum;
            }
        }
        return numOut;
    }

    public int[][] getMove(){

        int[][] move = new int[2][2];
        for(int runNum = 1; runNum <= 2; runNum++){
            while(true){
                if(runNum == 1){
                    System.out.print(name + ", input your location to move from. (EX: A7)\n>> ");
                }
                else{
                    System.out.print(name + ", input you location to move to. (EX: C8)\n>> ");
                }
                String moveIn = scanner.nextLine().trim();

                if(!moveIn.isEmpty() && moveIn.length() <= 2 && !(moveIn.contains(" ") || moveIn.contains("\t"))){
                    if(!Character.isDigit(moveIn.charAt(0)) && Character.isDigit(moveIn.charAt(1))){
                        int x, y;
                        if((x = convertCharToNum(Character.toUpperCase(moveIn.charAt(0)))) != -1){
                            if((y = convertCharNumToNum(moveIn.charAt(1))) != -1){
                                y = 8 - y;
                                int tempArray[] = {x, y};
                                if(runNum == 1){
                                    if(Board.board[y][x].getType().equalsIgnoreCase("blank") || !Board.board[y][x].getColor().equalsIgnoreCase(color)){
                                        tempArray[0] = -1;
                                        tempArray[1] = -1;
                                        return new int[][]{tempArray, tempArray};
                                    }
                                }
                                move[runNum - 1] = tempArray;
                                break;
                            }
                        }
                    }
                }
                System.out.println("Invalid location. Try again.");
            }
        }
        return move;
    }
}
