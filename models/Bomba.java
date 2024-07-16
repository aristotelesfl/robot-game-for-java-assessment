package models;

import java.util.Arrays;

public class Bomba extends Obstaculo{
    public Bomba(int[] posicao){
        super(posicao);
        this.id = 2;
    }
    @Override
    public <T> void bater(Robot player, T direction) {
        if (Arrays.equals(player.position, this.getPosicao())) player.isDead = true;
    }
}
