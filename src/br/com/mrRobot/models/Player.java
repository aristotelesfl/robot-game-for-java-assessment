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
        switch (comand){
            case 1:
                this.move("up");
                break;
            case 2:
                this.move("down");
                break;
            case 3:
                this.move("left");
                break;
            case 4:
                this.move("right");
                break;
            default:
                System.out.println("Ação inválida!");
        }
    }
    public boolean gameEnd(boolean foundFood){
        if (foundFood == true){
            wonGame = true;
        }
        return wonGame;
    }
}
