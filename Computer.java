public class Computer {

    private Board board;

    public Computer(Board board) {
        this.board = board;
    }

    public void makeMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = { -1, -1 }; // to store the best move coordinates

        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                // Check if the cell is empty
                if (board.getGameBoard()[i][j] == '-') {
                    board.getGameBoard()[i][j] = 'o'; // place 'o' for computer's move
                    int score = minimax(false); // false because next move is the player's move
                    board.getGameBoard()[i][j] = '-'; // reset cell
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        board.placeMove(bestMove[0], bestMove[1], 'o'); // place the best move for the computer
    }

    public int minimax(boolean isMaximizing) {
        char winner = board.checkWinner();
        if (winner == 'x') {
            return -10; // player wins, so it's a bad outcome for the computer
        } else if (winner == 'o') {
            return 10; // computer wins
        } else if (finalGame.isDraw(board)) {
            return 0; // it's a draw
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    if (board.getGameBoard()[i][j] == '-') {
                        board.getGameBoard()[i][j] = 'o';
                        int score = minimax(false);
                        board.getGameBoard()[i][j] = '-';
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    if (board.getGameBoard()[i][j] == '-') {
                        board.getGameBoard()[i][j] = 'x';
                        int score = minimax(true);
                        board.getGameBoard()[i][j] = '-';
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
    }
}
