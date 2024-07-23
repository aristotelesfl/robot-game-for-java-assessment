package br.com.robotGame.models.environment;

import br.com.robotGame.exceptions.MovimentoInvalidoException;
import br.com.robotGame.models.entities.Robot;

public abstract class Obstaculo {
    protected Obstaculo(int[] posicao){
        this.posicao = posicao;
    }
    protected int id;
    private final int[] posicao;
    public abstract <T> void bater(Robot player, T direction) throws MovimentoInvalidoException;

    public int[] getPosicao() {
        return posicao;
    }

    public int getId() {
        return id;
    }
}
