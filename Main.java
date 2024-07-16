import exceptions.MovimentoInvalidoException;
import gameMode.GameMode;
import gameMode.MultiPlayer;
import gameMode.SinglePlayer;
import models.Robot;
import models.SmartRobot;

public class Main {
    public static void main(String[] args) throws MovimentoInvalidoException {
        GameMode singlePlayer = new SinglePlayer();
        singlePlayer.playGame();
    }
}