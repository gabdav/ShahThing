public abstract class Board {

    static final char SIDE_LETTERS[] = {'A','B','C','D','E','F','G','H'};
    static final int SIDE_NUMS[] = {1,2,3,4,5,6,7,8};

    public static Square board[][] = new Square[8][8];

    abstract void setupBoard();

    private void update(int[] origLoc, int[] newLoc){
        board[newLoc[1]][newLoc[0]] = board[origLoc[1]][origLoc[0]];
        board[origLoc[1]][origLoc[0]] = new Square("empty");
    }

    public void draw(){
        System.out.print("\n   ");

        for(char i: SIDE_LETTERS){
            System.out.print("  " + i + "  ");
        }
        System.out.print("\n   ");

        for(int i = 0; i < 8; i++){
            System.out.print(" --- ");
        }

        System.out.print("\n");
        for(int i = 0; i < 8; i++){
            System.out.print(" " + (8 - i) + " ");

            for(Square j: board[i]){
                System.out.print("|" + j.getSymbol() + "|");
            }
            System.out.print(" " + (8 - i) + " ");

            System.out.print("\n   ");

            for(int j = 0; j < 8; j++){
                System.out.print(" --- ");
            }
            System.out.print("\n");
        }
        System.out.print("   ");
        for(char i: SIDE_LETTERS){
            System.out.print("  " + i + "  ");
        }
        System.out.print("\n\n");
    }
}
