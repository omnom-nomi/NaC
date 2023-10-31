import java.util.*;

public class Player {
    private Board gameBoard;
    Scanner sc = new Scanner(System.in);

    public Player(Board board) {
        this.gameBoard = board;
    }

    public boolean makeMove() {

        while (true) {

            try {

                System.out.println("Please enter the column (0,1, or 2): ");
                int row = sc.nextInt();
                System.out.println("Please enter the row (0,1, or 2): ");
                int column = sc.nextInt();

                if (row < 0 || column < 0 || row >= Board.SIZE || column >= Board.SIZE) {
                    System.out.println("Out of bounds.");
                    continue;
                } else if (gameBoard.getGameBoard()[row][column] != '-') {
                    System.out.println("That space has already been taken.");
                    continue;
                } else {
                    gameBoard.placeMove(row, column, 'x');
                    return true;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Try again.");
                sc.nextLine();
            }
        }
    }

}
