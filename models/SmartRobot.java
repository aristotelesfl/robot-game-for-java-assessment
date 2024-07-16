package models;

import exceptions.MovimentoInvalidoException;

public class SmartRobot extends Robot{
    public SmartRobot(String color) {
        super(color);
    }

    public SmartRobot(){};
    @Override
    public void mover(int direction) throws MovimentoInvalidoException {
        switch (direction) {
            case 1 -> {
                if ((this.position[0] > 0)) {
                    this.position[0]--;
                } else {
                    this.position[0]++;
                }
            }
            case 2 -> {
                if ((this.position[0] < 3)) {
                    this.position[0]++;
                } else {
                    this.position[0]--;
                }
            }
            case 3 -> {
                if ((this.position[1] > 0)) {
                    this.position[1]--;
                } else {
                    this.position[1]++;
                }
            }
            case 4 -> {
                if ((this.position[1] < 3)) {
                    this.position[1]++;
                } else {
                    this.position[1]--;
                }
            }
            default -> throw new MovimentoInvalidoException("Direção desconhecida");
        }
    }
}
