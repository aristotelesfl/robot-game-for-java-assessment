package gameMode;

import exceptions.MovimentoInvalidoException;
import exceptions.PosicaoInvalidaException;

public interface GameMode {
    void playGame() throws MovimentoInvalidoException, PosicaoInvalidaException;
}
