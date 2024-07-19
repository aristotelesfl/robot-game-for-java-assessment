package models;

import exceptions.MovimentoInvalidoException;

import java.util.Arrays;

public class Pedra extends Obstaculo{
    public Pedra(int[] posicao){
        super(posicao);
        this.id = 1;
    }
    @Override
    public <T> void bater(Robot player, T direction) throws MovimentoInvalidoException {
        if (Arrays.equals(player.getPosition(), this.getPosicao())){
            String d = (direction instanceof Integer) ? Integer.toString((Integer) direction) : (String) direction;
            switch (d) {
                case "1", "up" -> player.mover("down");
                case "2", "down" -> player.mover("up");
                case "3", "left" -> player.mover("right");
                case "4", "right" -> player.mover("left");
            }
        }
    }
}
