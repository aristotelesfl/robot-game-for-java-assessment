package gameMode;
import exceptions.MovimentoInvalidoException;
import models.Board;
import models.Food;
import models.Obstaculo;
import models.Robot;

import java.util.ArrayList;
import java.util.Scanner;

public class SinglePlayer implements GameMode {
    private final Scanner input = new Scanner(System.in);
    private int rounds = 0;
    private final Food food = new Food();
    private final Board board = new Board();
    private final NewGame newGame = new NewGame();

    public void playGame(){
        newGame.play(food);
        Robot player = new Robot(newGame.setColor(1));
        ArrayList<Obstaculo> obstaculos = newGame.criarObstaculos();
        while (!player.winGame(food.getPosition())) {
            try {
                board.generateBoard(player, food.getPosition(), obstaculos);
                System.out.print("""
                        1 representa “up”, 2 representa “down”, 3 representa “right” e 4 representa “left”
                        Selecione uma direção para se mover:\s""");
                Object direction = (input.hasNextInt()) ? input.nextInt() : input.next();
                if (direction instanceof String) player.mover((String) direction);
                else player.mover((int) direction);
                for (Obstaculo obstaculo : obstaculos) {
                    obstaculo.bater(player, direction);
                }
                rounds++;
            } catch (MovimentoInvalidoException | IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        System.out.println("Você venceu em " + rounds + " rodadas!");
    }
}
