public class Computer {
    private Board gameBoard;

    public Computer(Board board) {
        this.gameBoard = board;
    }

    public void makeMove() {
        if (tryToWin('o'))
            return;
        if (tryToWin('x'))
            return;
        if (placeMove(1, 1, 'o'))
            return;
        if (takeCorner('o'))
            return;

        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (placeMove(i, i, 'o'))
                    return;
            }
        }
    }

    private boolean tryToWin(char player) {
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (gameBoard.getGameBoard()[i][j] == '-') {
                    gameBoard.placeMove(i, j, player);
                    if (gameBoard.checkWinner() == player) {
                        if (player == 'x') {
                            gameBoard.placeMove(i, j, '-');
                        }
                        return true;
                    }

                    gameBoard.placeMove(i, j, '-');
                }
            }
        }
        return false;
    }

    private boolean placeMove(int i, int j, char player) {
        if (gameBoard.getGameBoard()[i][j] == '-') {
            gameBoard.placeMove(i, j, player);
            return true;
        }
        return false;
    }

    private boolean takeCorner(char player) {
        int[][] corners = { { 0, 0 }, { 0, 2 }, { 2, 0 }, { 2, 2 } };
        for (int[] corner : corners) {
            if (placeMove(corner[0], corner[1], player))
                ;
        }
        return false;
    }
}
