package models;

import exceptions.MovimentoInvalidoException;

public class Pedra extends Obstaculo{
    public Pedra(int[] posicao){
        super(posicao);
        this.id = 1;
    }
    @Override
    public <T> void bater(Robot player, T direction) throws MovimentoInvalidoException {
        String d = (direction instanceof Integer) ? Integer.toString((Integer) direction) : (String) direction;
        switch (d) {
            case "1":
            case "up":
                player.mover("down");
                break;
            case "2":
            case "down":
                player.mover("up");
                break;
            case "3":
            case "rigth":
                player.mover("left");
                break;
            case "4":
            case "left":
                player.mover("rigth");
                break;
        }
    }
}
