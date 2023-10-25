public class finalGame {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Player person = new Player(gameBoard);
        Computer comp = new Computer(gameBoard);

        while (true) {
            person.makeMove();
            gameBoard.displayBoard();

            if (gameOver(gameBoard)) {
                break;
            }

            comp.makeMove();
            // gameBoard.displayBoard();

            if (gameOver(gameBoard)) {
                break;
            }

        }

    }

    public static boolean gameOver(Board board) {
        char winner = board.checkWinner();
        if (winner == 'x') {
            System.out.println("You win.");
        } else if (winner == 'o') {
            System.out.println("The computer wins.");
            return true;
        }

        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (board.getGameBoard()[i][j] == '-') {
                    return false;
                }
            }
        }

        System.out.println("It's a draw");
        return true;
    }
}
