public abstract class Game {

    private Player player1;
    private Player player2;
    private Board board;
    private Piece[] pieces;

    public Game() {

    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }

    public void createBoardForGame(Board board){
        if(this.player1 == null || this.player2 == null){
            //EXCEPTIE TO DO
        }
        this.board = board;
            board.setupBoard();


    }

}
