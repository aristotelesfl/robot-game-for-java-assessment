package br.com.robotGame;

import br.com.robotGame.exceptions.MovimentoInvalidoException;
import br.com.robotGame.exceptions.PosicaoInvalidaException;
import br.com.robotGame.modes.GameMode;
import br.com.robotGame.modes.NewGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MovimentoInvalidoException, PosicaoInvalidaException {
        NewGame init = new NewGame();
        GameMode mode = init.selectGameMode();
        mode.playGame();
    }
}
