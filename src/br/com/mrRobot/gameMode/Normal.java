package br.com.mrRobot.gameMode;
import br.com.mrRobot.functions.FoundFood;
import br.com.mrRobot.functions.GameInit;
import br.com.mrRobot.models.Board;
import br.com.mrRobot.models.Player;

import java.util.Scanner;

public class Normal implements PlayGame {
    private final GameInit play = new GameInit();
    private final Board board = new Board();
    @Override
    public void playGame() {
        play.initGame();
        Player normalPlayer = new Player(play.getColor());
        while (!normalPlayer.endGame(new FoundFood().foundFood(normalPlayer, play.getPositionFood()))){
            board.generateBoard(normalPlayer, play.getPositionFood());
            System.out.print("Mova seu robô: ");
            normalPlayer.move(new Scanner(System.in).nextInt());
        }
        System.out.println("Você venceu em: "+normalPlayer.getRounds()+" rounds");
    }
}
