package br.com.robotGame.modes;

import br.com.robotGame.exceptions.MovimentoInvalidoException;
import br.com.robotGame.exceptions.PosicaoInvalidaException;
import br.com.robotGame.models.entities.Robot;
import br.com.robotGame.models.entities.SmartRobot;
import br.com.robotGame.models.environment.Board;
import br.com.robotGame.models.environment.Food;
import br.com.robotGame.models.environment.Obstaculo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiPlayer implements GameMode {
    private final Scanner input = new Scanner(System.in);
    private int rounds = 0;
    private final Food food = new Food();
    private final Board board = new Board();
    private final NewGame newGame = new NewGame();

    @Override
    public void playGame() {
        ArrayList<Robot> players = new ArrayList<>();
        selectGameMode(players);
        int numPlayer = 0;
        boolean isDead = false;
        newGame.play(food);
        for (Robot player : players){
            while (true) {
                try {
                    player.setColor(newGame.setColor(players.indexOf(player)+1));
                    break;
                } catch (IllegalArgumentException e) {
                    e.getMessage();
                }
            }
        }
        ArrayList<Obstaculo> obstaculos = null;
        try {
            obstaculos = newGame.criarObstaculos();
        } catch (PosicaoInvalidaException e){
            e.getMessage();
        }
        while (!players.get(0).winGame(food.getPosition()) && !players.get(1).winGame(food.getPosition()) && (!players.get(0).isDead || !players.get(1).isDead)){
            try {
                for (Robot player : players) {
                    if (!player.isDead) {
                        System.out.println("Movendo Player " + (players.indexOf(player)+1) + " aleatoriamente...");
                        board.generateBoard(players, food.getPosition(), obstaculos);
                        Thread.sleep(2000);
                        int aleatory = player.aleatoryDirection();
                        player.mover(aleatory);
                        ArrayList<Obstaculo> obstaculosARemover = new ArrayList<>();
                        for (Obstaculo obstaculo : obstaculos) {
                            obstaculo.bater(player, aleatory);
                            if (player.isDead) {
                                obstaculosARemover.add(obstaculo);
                            }
                        }

                        obstaculos.removeAll(obstaculosARemover);
                    } else if (!isDead) {
                        numPlayer = (players.indexOf(player)+1);
                        System.out.printf("O player %d morreu em %d rounds\n", numPlayer, rounds);
                        isDead = true;
                    }
                }
                rounds++;
            } catch (MovimentoInvalidoException | IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("Thread foi interrompida!");
            }
        }
        if (players.get(0).isDead && players.get(1).isDead) System.out.printf("O player %d morreu em %d rounds\nFim de Jogo!", ((numPlayer!=1) ? 1 : 2), rounds);
        else System.out.println("O player " + ((players.get(0).winGame(food.getPosition())) ? 1 : 2) + " venceu em " + rounds + " rodadas!");
    }

    public void selectGameMode(ArrayList<Robot> listOfPlayers) {
        boolean validOptionSelected = false;

        while (!validOptionSelected) {
            System.out.print("""
                --- Modos de jogo ---
                1 - Normal vs Normal
                2 - Normal vs Inteligente
                3 - Inteligente vs Inteligente
                Selecione uma opção:\s""");

            try {
                int option = input.nextInt();
                switch (option) {
                    case 1 -> {
                        listOfPlayers.add(new Robot());
                        listOfPlayers.add(new Robot());
                        validOptionSelected = true;
                    }
                    case 2 -> {
                        listOfPlayers.add(new Robot());
                        listOfPlayers.add(new SmartRobot());
                        validOptionSelected = true;
                    }
                    case 3 -> {
                        listOfPlayers.add(new SmartRobot());
                        listOfPlayers.add(new SmartRobot());
                        validOptionSelected = true;
                    }
                    default -> System.out.println("Entrada Inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("O valor digitado deve ser um inteiro!");
                input.next();
            }

        }
    }
}
