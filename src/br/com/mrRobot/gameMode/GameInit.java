package br.com.mrRobot.gameMode;
import java.util.Random;
import java.util.Scanner;

import static br.com.mrRobot.functions.ColorMap.colorMap;

public class GameInit {
    private Scanner input = new Scanner(System.in);
    private String color = new String();
    private int[] positionFood = new int[2];
    public void initGame() {
        System.out.println("Iniciando Game");
        System.out.printf("%s - %s - %s - %s - %s\n",
                colorMap("vermelho", "Vermelho"),
                colorMap("verde", "Verde"),
                colorMap("amarelo", "Amarelo"),
                colorMap("azul", "Azul"),
                colorMap("ciano", "Ciano"));
        System.out.print("Selecione uma cor: ");
        color = input.next();
        System.out.print("Indique a posição do alimento: ");
        for (int i = 0; i < 2; i++) {
            positionFood[i] = input.nextInt();
        }
    }
    public String getColor() {
        return color;
    }
    public int[] getPositionFood() {
        return positionFood;
    }
    public int[] generatePosition(){
        int[] position = new int[2];
        Random randomNum = new Random();
        for (int i=0; i<2; i++){
            position[i] = randomNum.nextInt(5);
        }
        return position;
    }
}