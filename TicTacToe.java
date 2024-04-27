import java.util.Scanner;

public class TicTacToe {
    private static char[][] board;
    private static char currentPlayer;
    private static boolean isGameEnded;

    public static void main(String[] args) {
        initializeBoard();
        currentPlayer = 'X';
        isGameEnded = false;

        while (!isGameEnded) {
            printBoard();
            playTurn();
            checkGameStatus();
            switchPlayer();
        }
    }

    private static void initializeBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2) separated by space:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
        } else {
            System.out.println("Invalid move! Try again.");
            playTurn();
        }
    }

    private static void checkGameStatus() {
        if (checkWinner(currentPlayer)) {
            printBoard();
            System.out.println("Player " + currentPlayer + " wins!");
            isGameEnded = true;
        } else if (isBoardFull()) {
            printBoard();
            System.out.println("It's a draw!");
            isGameEnded = true;
        }
    }

    private static boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
