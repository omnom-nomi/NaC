public class Board {
    private final int SIZE = 3;
    private char[][] gameBoard = new char[SIZE][SIZE];

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
                System.out.println(gameBoard[i][j] + " ");
            }

            System.out.println();
        }

    }

    public boolean placeMove(int x, int y, char player) {
        return false;
    }

}
