package br.com.mrRobot.models;

public class Player extends Robot {
    private int rounds;
    private boolean wonGame;

    public int getRounds() {
        return rounds;
    }

    public void coutRounds(){
        this.rounds++;
    }

    public Player(String color) {
        super(color);
        this.rounds = 0;
        this.wonGame = false;
    }
    @Override
    public void move(int comand){
        this.coutRounds();
        switch (comand) {
            case 1 -> this.move("up");
            case 2 -> this.move("down");
            case 3 -> this.move("left");
            case 4 -> this.move("right");
            default -> System.out.println("Ação inválida!");
        }
    }
    public boolean endGame(boolean foundFood){
        if (foundFood){
            wonGame = true;
        }
        return wonGame;
    }
}
