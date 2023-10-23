public class finalGame {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Player person = new Player(gameBoard);
        Computer comp = new Computer(gameBoard);
    }
}
