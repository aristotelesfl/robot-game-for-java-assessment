package gameMode;
import models.Bomba;
import models.Food;
import models.Obstaculo;
import models.Pedra;

import java.util.ArrayList;
import java.util.Scanner;
import static models.ColorMap.colorMap;

public class NewGame {
    private Scanner input = new Scanner(System.in);
    public void play(Food food) {
        int[] positionFood = new int[2];
        System.out.println("Iniciando Game");
        System.out.print("Indique a posição do alimento: ");
        for (int i = 0; i < 2; i++) {
            positionFood[i] = input.nextInt();
        }
        food.setPosition(positionFood);
        System.out.printf("%s - %s - %s - %s - %s\n",
                colorMap("vermelho", "Vermelho"),
                colorMap("verde", "Verde"),
                colorMap("amarelo", "Amarelo"),
                colorMap("azul", "Azul"),
                colorMap("ciano", "Ciano"));
    }
    public String setColor(int i){
        System.out.print("Selecione uma cor para o Player" + i + ": ");
        String color = input.next();
        return color;
    }

    public ArrayList<Obstaculo> criarObstaculos() {
        ArrayList<Obstaculo> obstaculos = new ArrayList<>();
        System.out.print("Quer colocar obstáculos? (y/n) ");
        boolean isTrue = input.next().equals("y");
        while (isTrue) {
            System.out.println("""
                    Selecione o tipo de obstáculo:
                    1 - Pedra
                    2 - Bomba""");
            int opcao = input.nextInt();
            System.out.print("Digite a posição do obstáculo: ");
            int[] posicao = new int[2];
            for (int i = 0; i < 2; i++) posicao[i] = input.nextInt();
            if (opcao == 1) obstaculos.add(new Pedra(posicao));
            else if (opcao == 2) obstaculos.add(new Bomba(posicao));
            else System.out.println("Obstáculo inválido!");
            System.out.print("Quer colocar mais obstáculos? (y/n) ");
            isTrue = input.next().equals("y");
        }
        return obstaculos;
    }
}
