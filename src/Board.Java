public class Board {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';

    private char[][] board;

    public Board() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
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

    public char[][] getBoard() {
        return board;
    }

    public static int getBoardSize() {
        return BOARD_SIZE;
    }

    public static char getEmptyCell() {
        return EMPTY_CELL;
    }
}

