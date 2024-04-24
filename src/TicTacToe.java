import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = PLAYER_X;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = EMPTY_CELL;
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.print("| ");
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public void makeMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != EMPTY_CELL) {
            System.out.println("Invalid move. Please try again.");
            return;
        }
        board[row][col] = currentPlayer;
        if (checkWin(row, col)) {
            System.out.println("Player " + currentPlayer + " wins!");
            System.exit(0);
        } else if (checkDraw()) {
            System.out.println("It's a draw!");
            System.exit(0);
        }
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X; // Switch players
    }

    private boolean checkWin(int row, int col) {
        char symbol = board[row][col];
        // Check row
        if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol)
            return true;
        // Check column
        if (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol)
            return true;
        // Check diagonals
        if ((row == col || row + col == BOARD_SIZE - 1) &&
                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol ||
                        board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol))
            return true;
        return false;
    }

    private boolean checkDraw() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        while (true) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + "'s turn. Enter row and column (0-2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            game.makeMove(row, col);
        }
    }
}
