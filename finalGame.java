public class finalGame {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Player person = new Player(gameBoard);
        Computer comp = new Computer(gameBoard);

        while (true) {
            person.makeMove();
            gameBoard.displayBoard();

            if (gameOver(gameBoard)) {
                System.out.println("You win.");
                break;
            }

            comp.makeMove();
            gameBoard.displayBoard();

            if (gameOver(gameBoard)) {
                System.out.println("The computer wins.");
                break;
            }

        }

        gameBoard.displayBoard();
    }

    public static boolean gameOver(Board board) {

        return false;
    }
}
