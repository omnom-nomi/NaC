public class Computer {

    private Board board;
    private static final char computer = 'o';
    private static final char player = 'x';

    public Computer(Board board) {
        this.board = board;
    }

    public void makeMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = { -1, -1 };

        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (board.getGameBoard()[i][j] == '-') {
                    board.getGameBoard()[i][j] = computer;
                    int score = minimax(0, false);
                    board.getGameBoard()[i][j] = '-';

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }

        board.placeMove(bestMove[0], bestMove[1], computer);
    }

    private int minimax(int depth, boolean isMaximizing) {
        char result = board.checkWinner();
        if (result != ' ') {
            if (result == computer)
                return 10;
            else if (result == player)
                return -10;
            else
                return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    if (board.getGameBoard()[i][j] == '-') {
                        board.getGameBoard()[i][j] = computer;
                        bestScore = Math.max(bestScore, minimax(depth + 1, false));
                        board.getGameBoard()[i][j] = '-';
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < Board.SIZE; i++) {
                for (int j = 0; j < Board.SIZE; j++) {
                    if (board.getGameBoard()[i][j] == '-') {
                        board.getGameBoard()[i][j] = player;
                        bestScore = Math.min(bestScore, minimax(depth + 1, true));
                        board.getGameBoard()[i][j] = '-';
                    }
                }
            }
            return bestScore;
        }
    }
}
