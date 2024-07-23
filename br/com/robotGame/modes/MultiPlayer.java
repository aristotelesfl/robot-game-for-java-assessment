package br.com.robotGame.modes;

import br.com.robotGame.exceptions.MovimentoInvalidoException;
import br.com.robotGame.exceptions.PosicaoInvalidaException;
import br.com.robotGame.models.entities.Robot;
import br.com.robotGame.models.entities.SmartRobot;
import br.com.robotGame.models.environment.Board;
import br.com.robotGame.models.environment.Food;
import br.com.robotGame.models.environment.Obstaculo;

import java.util.ArrayList;
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
                        for (Obstaculo obstaculo : obstaculos) {
                            obstaculo.bater(player, aleatory);
                        }
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
        System.out.print("""
                --- Modos de jogo ---
                1 - Normal vs Normal
                2 - Normal vs Inteligente
                3 - Inteligente vs Inteligente
                Selecione uma opção:\s""");
        int option = input.nextInt();
        switch (option) {
            case 1 -> {
                listOfPlayers.add(new Robot());
                listOfPlayers.add(new Robot());
            }
            case 2 -> {
                listOfPlayers.add(new Robot());
                listOfPlayers.add(new SmartRobot());
            }
            case 3 -> {
                listOfPlayers.add(new SmartRobot());
                listOfPlayers.add(new SmartRobot());
            }
            default -> System.out.println("Entrada Inválida!");
        }
    }
}
