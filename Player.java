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
            int row = sc.nextInt();
            System.out.println("Please enter the column");
            int column = sc.nextInt();

            if (row < 0 || column < 0 || row >= Board.SIZE || column >= Board.SIZE) {
                System.out.println("Out of bounds;");
                continue;
            } else if (gameBoard.getGameBoard()[column][row] != '-') {
                System.out.println("Someone already took that space");
                continue;
            } else {
                gameBoard.placeMove(column, row, 'x');
                return true;
            }
        }
    }
}
