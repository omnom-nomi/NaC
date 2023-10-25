public class finalGame {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Player person = new Player(gameBoard);
        Computer comp = new Computer(gameBoard);

        boolean gameEnded = false;

        while (!gameEnded) {
            person.makeMove();
            gameBoard.displayBoard();

            if (gameOver(gameBoard)) {
                gameEnded = true;
                continue;
            }

            comp.makeMove();
            // gameBoard.displayBoard();

            if (gameOver(gameBoard)) {
                gameEnded = true;
            }

        }
        gameBoard.displayBoard();
    }

    public static boolean gameOver(Board board) {
        char winner = board.checkWinner();

        if (winner == 'x') {
            System.out.println("You win.");
            return true;
        } else if (winner == 'o') {
            System.out.println("The computer wins.");
            return true;
        }

        if (isDraw(board)) {
            System.out.println("It's a draw.");
            return true;
        }

        return false; // Return false if no winner and it's not a draw
    }

    public static boolean isDraw(Board board) {
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (board.getGameBoard()[i][j] == '-') {
                    return false; // Return false immediately if an empty spot is found.
                }
            }
        }
        return true; // Return true if no empty spots found (indicating a draw).
    }
}