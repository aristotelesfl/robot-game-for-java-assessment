import br.com.mrRobot.models.Board;
import br.com.mrRobot.models.Player;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("azul");
        Board newBoard = new Board();
        int[] food = {1, 2};
        newBoard.generateBoard(player1, food);
        player1.move(1);
        System.out.println();
        newBoard.generateBoard(player1, food);
        player1.move(3);
        System.out.println();
        newBoard.generateBoard(player1, food);
        player1.move(3);
        System.out.println();
        newBoard.generateBoard(player1, food);
    }
}