package br.com.robotGame.modes;

import br.com.robotGame.exceptions.PosicaoInvalidaException;
import br.com.robotGame.models.environment.Bomba;
import br.com.robotGame.models.environment.Food;
import br.com.robotGame.models.environment.Obstaculo;
import br.com.robotGame.models.environment.Pedra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static br.com.robotGame.utils.ColorMap.colorMap;

public class NewGame {
    private final Scanner input = new Scanner(System.in);
    private final int[] positionFood = new int[2];

    public void play(Food food) {
        System.out.println("Iniciando Jogo");
        System.out.print("Indique a posição do alimento: ");
        for (int i = 0; i < 2; i++) {
            while (true) {
                try {
                    positionFood[i] = getPositionInput();
                    break;
                } catch (PosicaoInvalidaException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        food.setPosition(positionFood);
        System.out.printf("%s - %s - %s - %s - %s\n",
                colorMap("vermelho", "Vermelho"),
                colorMap("verde", "Verde"),
                colorMap("amarelo", "Amarelo"),
                colorMap("azul", "Azul"),
                colorMap("ciano", "Ciano"));
    }

    private int getPositionInput() throws PosicaoInvalidaException {
        int pos;
        try {
            pos = input.nextInt();
            if (pos < 0 || pos > 3) {
                throw new PosicaoInvalidaException("Erro: A posição deve estar entre 0 e 3!");
            }
        } catch (InputMismatchException e) {
            input.next();
            throw new PosicaoInvalidaException("Erro: A posição deve ser um número inteiro!");
        }
        return pos;
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
            int opcao = 0;
            while (true) {
                try {
                    opcao = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("O valor digitado deve ser um inteiro!");
                    input.next();
                }
            }
            boolean isValid = false;
            while (!isValid) {
                System.out.print("Digite a posição do obstáculo: ");
                int[] posicao = new int[2];
                for (int i = 0; i < 2; i++) {
                    while (true) {
                        try {
                            posicao[i] = getPositionInput();
                            break;
                        } catch (PosicaoInvalidaException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

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

    public GameMode selectGameMode() {
        GameMode mode = null;
        while (mode == null) {
            System.out.println("""
                    Selecione um modo de jogo:
                    1 - 1 Jogador
                    2 - 2 Jogadores""");

            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> mode = new SinglePlayer();
                    case 2 -> mode = new MultiPlayer();
                    default -> System.out.println("Opção Inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("O valor digitado deve ser um inteiro!");
                input.next();
            }
        }
        return mode;
    }
}
