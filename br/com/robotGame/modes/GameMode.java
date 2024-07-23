package br.com.robotGame.modes;

import br.com.robotGame.exceptions.MovimentoInvalidoException;
import br.com.robotGame.exceptions.PosicaoInvalidaException;

public interface GameMode {
    void playGame() throws MovimentoInvalidoException, PosicaoInvalidaException;
}
