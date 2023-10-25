public class Board {
    public static final int SIZE = 3;
    private char[][] gameBoard = new char[SIZE][SIZE];

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public Board() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }

    }

    public boolean placeMove(int row, int column, char b) {
        if (row >= 0 && row < SIZE && column >= 0 && column < SIZE && gameBoard[row][column] == '-') {
            gameBoard[row][column] = b;
            return true;
        } else {
            return false;
        }
    }

    public char checkWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != '-') {
                return gameBoard[i][0];
            }
        }
        return '-';
    }

}
