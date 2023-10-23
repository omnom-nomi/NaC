public class finalGame {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Player user = new Player(gameBoard);
        Computer ai = new Computer(gameBoard);
    }
}
