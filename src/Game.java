public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public Game(Board board, Player playerX, Player playerO) {
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX; // Player X starts the game
    }

    public void makeMove(int row, int col) {
        char[][] boardArray = board.getBoard();
        if (row < 0 || row >= Board.getBoardSize() || col < 0 || col >= Board.getBoardSize() || boardArray[row][col] != Board.getEmptyCell()) {
            System.out.println("Invalid move. Please try again.");
            return;
        }
        boardArray[row][col] = currentPlayer.getSymbol();
        if (checkWin(row, col)) {
            System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
            System.exit(0);
        } else if (checkDraw(boardArray)) {
            System.out.println("It's a draw!");
            System.exit(0);
        }
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX; // Switch players
    }

    private boolean checkWin(int row, int col) {
        char[][] boardArray = board.getBoard();
        char symbol = boardArray[row][col];
        // Check row
        if (boardArray[row][0] == symbol && boardArray[row][1] == symbol && boardArray[row][2] == symbol)
            return true;
        // Check column
        if (boardArray[0][col] == symbol && boardArray[1][col] == symbol && boardArray[2][col] == symbol)
            return true;
        // Check diagonals
        if ((row == col || row + col == Board.getBoardSize() - 1) &&
                (boardArray[0][0] == symbol && boardArray[1][1] == symbol && boardArray[2][2] == symbol ||
                        boardArray[0][2] == symbol && boardArray[1][1] == symbol && boardArray[2][0] == symbol))
            return true;
        return false;
    }

    private boolean checkDraw(char[][] boardArray) {
        for (int row = 0; row < Board.getBoardSize(); row++) {
            for (int col = 0; col < Board.getBoardSize(); col++) {
                if (boardArray[row][col] == Board.getEmptyCell()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
