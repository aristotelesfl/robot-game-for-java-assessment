package br.com.robotGame.models.entities;

import br.com.robotGame.exceptions.MovimentoInvalidoException;

import java.util.Arrays;
import java.util.Random;

public class Robot{
    private String color;
    public boolean isDead = false;
    protected int[] position = {0, 0};
    public Robot(String color) {
        this.color = color;
    }

    public Robot() {}

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void mover(String direction) throws MovimentoInvalidoException {
        switch (direction) {
            case "up" -> {
                if (this.position[0] > 0) {
                    this.position[0]--;
                } else {
                    throw new MovimentoInvalidoException("Ação Inválida: não pode mover para cima");
                }
            }
            case "down" -> {
                if (this.position[0] < 3) {
                    this.position[0]++;
                } else {
                    throw new MovimentoInvalidoException("Ação Inválida: não pode mover para baixo");
                }
            }
            case "left" -> {
                if (this.position[1] > 0) {
                    this.position[1]--;
                } else {
                    throw new MovimentoInvalidoException("Ação Inválida: não pode mover para a esquerda");
                }
            }
            case "right" -> {
                if (this.position[1] < 3) {
                    this.position[1]++;
                } else {
                    throw new MovimentoInvalidoException("Ação Inválida: não pode mover para a direita");
                }
            }
            default -> throw new MovimentoInvalidoException("Direção desconhecida");
        }
    }

    public void mover(int direction) throws MovimentoInvalidoException {
        switch (direction) {
            case 1 -> {
                if (this.position[0] > 0) {
                    this.position[0]--;
                } else {
                    throw new MovimentoInvalidoException("Ação Inválida: não pode mover para cima");
                }
            }
            case 2 -> {
                if (this.position[0] < 3) {
                    this.position[0]++;
                } else {
                    throw new MovimentoInvalidoException("Ação Inválida: não pode mover para baixo");
                }
            }
            case 3 -> {
                if (this.position[1] > 0) {
                    this.position[1]--;
                } else {
                    throw new MovimentoInvalidoException("Ação Inválida: não pode mover para a esquerda");
                }
            }
            case 4 -> {
                if (this.position[1] < 3) {
                    this.position[1]++;
                } else {
                    throw new MovimentoInvalidoException("Ação Inválida: não pode mover para a direita");
                }
            }
            default -> throw new MovimentoInvalidoException("Direção desconhecida");
        }
    }

    public int aleatoryDirection(){
        int position;
        Random randomNum = new Random();
        position = randomNum.nextInt(4)+1;
        return position;
    }

    public boolean winGame(int[] positionFood) {
        return Arrays.equals(this.position, positionFood);
    }
}
