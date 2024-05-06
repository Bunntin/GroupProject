import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        Game game = new Game(board, playerX, playerO);

        while (true) {
            board.printBoard();
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn. Enter row and column (0-2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            game.makeMove(row, col);
        }
    }
}
