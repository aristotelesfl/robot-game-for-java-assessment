package gameMode;
import exceptions.PosicaoInvalidaException;
import models.Bomba;
import models.Food;
import models.Obstaculo;
import models.Pedra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static models.ColorMap.colorMap;

public class NewGame {
    private final Scanner input = new Scanner(System.in);
    private final int[] positionFood = new int[2];

    public void play(Food food) {
        System.out.println("Iniciando Jogo");
        System.out.print("Indique a posição do alimento: ");
        for (int i = 0; i < 2; i++) {
            positionFood[i] = input.nextInt();
        }
        input.nextLine();
        food.setPosition(positionFood);
        System.out.printf("%s - %s - %s - %s - %s\n",
                colorMap("vermelho", "Vermelho"),
                colorMap("verde", "Verde"),
                colorMap("amarelo", "Amarelo"),
                colorMap("azul", "Azul"),
                colorMap("ciano", "Ciano"));
    }

    public String setColor(int i) {
        String cor = "";
        boolean isValidColor = false;
        while (!isValidColor) {
            System.out.print("Selecione uma cor para o Jogador " + i + ": ");
            cor = input.next();
            try {
                colorMap(cor, "");
                isValidColor = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: Cor Inválida! Tente novamente.");
            }
        }
        return cor;
    }

    public ArrayList<Obstaculo> criarObstaculos() throws PosicaoInvalidaException {
        ArrayList<Obstaculo> obstaculos = new ArrayList<>();
        System.out.print("Quer colocar obstáculos? (y/n) ");
        boolean isTrue = input.next().equals("y");
        while (isTrue) {
            System.out.println("""
                    Selecione o tipo de obstáculo:
                    1 - Pedra
                    2 - Bomba""");
            int opcao = input.nextInt();
            boolean isValid = false;
            while (!isValid) {
                System.out.print("Digite a posição do obstáculo: ");
                int[] posicao = new int[2];
                for (int i = 0; i < 2; i++) posicao[i] = input.nextInt();

                if (Arrays.equals(posicao, positionFood)) {
                    System.out.println("Erro: Posição do obstáculo não pode ser igual à posição do alimento!");
                } else {
                    isValid = true;
                    for (Obstaculo obstaculo : obstaculos) {
                        if (Arrays.equals(posicao, obstaculo.getPosicao())) {
                            isValid = false;
                            System.out.println("Erro: Posição já ocupada por outro obstáculo!");
                            break;
                        }
                    }

                    if (isValid) {
                        if (opcao == 1) obstaculos.add(new Pedra(posicao));
                        else if (opcao == 2) obstaculos.add(new Bomba(posicao));
                        else {
                            System.out.println("Obstáculo inválido!");
                            isValid = false;
                        }
                    }
                }
            }
            System.out.print("Quer colocar mais obstáculos? (y/n) ");
            isTrue = input.next().equals("y");
        }
        return obstaculos;
    }
}
