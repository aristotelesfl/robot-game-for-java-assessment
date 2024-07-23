package br.com.robotGame;

import br.com.robotGame.exceptions.MovimentoInvalidoException;
import br.com.robotGame.exceptions.PosicaoInvalidaException;
import br.com.robotGame.modes.GameMode;
import br.com.robotGame.modes.MultiPlayer;
import br.com.robotGame.modes.SinglePlayer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MovimentoInvalidoException, PosicaoInvalidaException {
        Scanner input = new Scanner(System.in);
        GameMode mode = null;

        while (mode == null) {
            System.out.println("""
                Selecione um modo de jogo:
                1 - 1 Jogador
                2 - 2 Jogadores""");

            int choice = input.nextInt();
            switch (choice) {
                case 1 -> mode = new SinglePlayer();
                case 2 -> mode = new MultiPlayer();
                default -> System.out.println("Opção Inválida!");
            }
        }

        mode.playGame();
        input.close();
    }
}