package br.com.mrRobot.gameMode;
import br.com.mrRobot.functions.FoundFood;
import br.com.mrRobot.models.Board;
import br.com.mrRobot.models.Player;
import java.lang.Thread;

public class Aleatory implements PlayGame {
    GameInit play = new GameInit();
    Board board = new Board();
    @Override
    public void playGame() {
        play.initGame();
        Player randomPlayer = new Player(play.getColor());
        while (randomPlayer.gameEnd(new FoundFood().foundFood(randomPlayer, play.getPositionFood()))==false){
            board.generateBoard(randomPlayer, play.getPositionFood());
            System.out.println("Movendo robô aleatoriamente...");
            randomPlayer.setPosition(play.generatePosition());
            randomPlayer.coutRounds();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Você venceu em: "+randomPlayer.getRounds()+" rounds");
    }
}
