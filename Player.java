import java.util.*;

public class Player {
    private Board gameBoard;
    Scanner sc = new Scanner(System.in);

    public Player(Board board) {
        this.gameBoard = board;
    }

    public boolean makeMove(int x, int y) {
        // Make the player's move and return success status
        // check if it's the player's turn currently
        boolean player = true;

        System.out.println("Please enter the row");
        int a = sc.nextInt();
        System.out.println("Please enter the column");
        int b = sc.nextInt();

        if (a < 0 || b < 0 || a >= Board.SIZE || b >= Board.SIZE) {
            System.out.println("Out of bounds;");
        } else if (gameBoard.getGameBoard()[a][b] != '-') {
            System.out.println("Someone already took that space");
        }
        ;

        return false;

    }
}
