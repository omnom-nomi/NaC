public class finalGame {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Player person = new Player(gameBoard);
        Computer comp = new Computer(gameBoard);

        boolean gameEnded = false;
        gameBoard.displayBoard();

        while (!gameEnded) {
            System.out.println("It's your turn:");
            person.makeMove();

            if (gameOver(gameBoard)) {
                gameEnded = true;
                continue;
            }

            System.out.println("It's the computer turn:");
            comp.makeMove();

            if (gameOver(gameBoard)) {
                gameEnded = true;
            }
        }
    }

    public static boolean gameOver(Board board) {
        board.displayBoard(); // Display the board here.

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
