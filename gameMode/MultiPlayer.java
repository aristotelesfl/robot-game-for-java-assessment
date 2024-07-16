package gameMode;

import exceptions.MovimentoInvalidoException;
import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiPlayer implements GameMode {
    private boolean temObstaculo;
    private final Scanner input = new Scanner(System.in);
    private int rounds = 0;
    private final Food food = new Food();
    private final Board board = new Board();
    private final NewGame newGame = new NewGame();

    @Override
    public void playGame() throws MovimentoInvalidoException {
        newGame.play(food);
        ArrayList<Robot> players = new ArrayList<Robot>();
        selectGameMode(players);
        for (Robot player : players){
            player.setColor(newGame.setColor(players.indexOf(player)+1));
        }
        ArrayList<Obstaculo> obstaculos = newGame.criarObstaculos();
        while (!players.get(0).winGame(food.getPosition()) && !players.get(1).winGame(food.getPosition())){
            try {
                for (Robot player : players) {
                    System.out.println("Movendo Player " + (players.indexOf(player)+1) + " aleatoriamente...");
                    board.generateBoard(players, food.getPosition(), obstaculos);
                    Thread.sleep(2000);
                    int aleatory = player.aleatoryDirection();
                    player.mover(aleatory);
                    for (Obstaculo obstaculo : obstaculos) {
                        obstaculo.bater(player, aleatory);
                    }
                }
                rounds++;
            } catch (MovimentoInvalidoException | IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("Thread foi interrompida!");
            }
        }
        System.out.println("O player " + ((players.get(0).winGame(food.getPosition())) ? 1 : 2) + " venceu em " + rounds + " rodadas!");
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
