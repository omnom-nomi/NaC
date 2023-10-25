import java.util.*;

public class Player {
    private Board gameBoard;
    Scanner sc = new Scanner(System.in);

    public Player(Board board) {
        this.gameBoard = board;
    }

    public boolean makeMove() {
        while (true) {

            System.out.println("Please enter the row");
            int a = sc.nextInt();
            System.out.println("Please enter the column");
            int b = sc.nextInt();

            if (a < 0 || b < 0 || a >= Board.SIZE || b >= Board.SIZE) {
                System.out.println("Out of bounds;");
                continue;
            } else if (gameBoard.getGameBoard()[a][b] != '-') {
                System.out.println("Someone already took that space");
                continue;
            } else {
                gameBoard.placeMove(a, b, 'x');
                return true;
            }
        }
    }
}
