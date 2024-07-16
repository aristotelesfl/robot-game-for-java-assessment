package models;

import exceptions.MovimentoInvalidoException;

public abstract class Obstaculo {
    protected Obstaculo(int[] posicao){
        this.posicao = posicao;
    }
    protected int id;
    private int[] posicao = new int[2];
    public abstract <T> void bater(Robot player, T direction) throws MovimentoInvalidoException;

    public int[] getPosicao() {
        return posicao;
    }

    public int getId() {
        return id;
    }
}
