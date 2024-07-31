package br.com.robotGame.models.entities;

import br.com.robotGame.exceptions.MovimentoInvalidoException;

public class SmartRobot extends Robot {

    private Integer invalidDirection = null;

    public SmartRobot() {}

    @Override
    public void mover(int direction) throws MovimentoInvalidoException {
        boolean invalidDirection = true;
        boolean printException = false;
        while (invalidDirection) {
            try {
                super.mover(direction);
                invalidDirection = false;
            } catch (MovimentoInvalidoException e) {
                if (!printException) {
                    System.out.println("Erro: " + e.getMessage());
                    printException = true;
                }
                direction = super.aleatoryDirection();
            }
        }
    }
}


