package gameMode;

import exceptions.MovimentoInvalidoException;

public interface GameMode {
    void playGame() throws MovimentoInvalidoException;
}
