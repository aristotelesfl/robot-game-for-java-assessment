package br.com.robotGame.models.environment;

import br.com.robotGame.models.entities.Robot;
import br.com.robotGame.utils.ColorMap;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private void printObstaculo(Obstaculo obstaculo, int[] position) {
        if (Arrays.equals(obstaculo.getPosicao(), position)) {
            if (obstaculo.getId() == 1) {
                System.out.print(ColorMap.colorMap("amarelo", "(  P  )"));
            } else {
                System.out.print(ColorMap.colorMap("amarelo", "(  B  )"));
            }
        }
    }

    private void printRobot(Robot player, int[] position) {
        if (Arrays.equals(player.getPosition(), position)) {
            try {
                System.out.print(ColorMap.colorMap(player.getColor(), "(  R  )"));
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void generateBoard(Object listOfPlayers, int[] positionFood, ArrayList<Obstaculo> obstaculos) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int[] position = {i, j};
                boolean isOccupied = false;

                if (listOfPlayers instanceof ArrayList<?> players) {
                    for (Object obj : players) {
                        if (obj instanceof Robot player) {
                            if (Arrays.equals(player.getPosition(), position) && !player.isDead) {
                                printRobot(player, position);
                                isOccupied = true;
                                break;
                            }
                        } else {
                            throw new IllegalArgumentException("O ArrayList deve conter apenas objetos do tipo Robot");
                        }
                    }
                } else if (listOfPlayers instanceof Robot player) {
                    if (Arrays.equals(player.getPosition(), position)) {
                        printRobot(player, position);
                        isOccupied = true;
                    }
                } else {
                    throw new IllegalArgumentException("O tipo de players deve ser ArrayList<Robot> ou Robot");
                }

                if (!isOccupied) {
                    for (Obstaculo obstaculo : obstaculos) {
                        if (Arrays.equals(obstaculo.getPosicao(), position)) {
                            printObstaculo(obstaculo, position);
                            isOccupied = true;
                            break;
                        }
                    }
                }

                if (!isOccupied) {
                    if (Arrays.equals(positionFood, position)) {
                        System.out.print(ColorMap.colorMap("amarelo", "(  A  )"));
                    } else {
                        System.out.printf("(%d , %d)", i, j);
                    }
                }

                if (j < 3) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
}
