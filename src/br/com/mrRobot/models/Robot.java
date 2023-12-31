package br.com.mrRobot.models;

import java.util.Locale;

public abstract class Robot {
    private String color;
    private int[] position = new int[2];

    public Robot(String color){
        this.color = color;
        this.position[0] = 0;
        this.position[1] = 0;
    }

    public String getColor() {
        return color.toLowerCase();
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }

    public void move(String comand){
        switch (comand.toLowerCase()){
            case "up":
                this.position[0]++;
                break;
            case "down":
                this.position[0]--;
                break;
            case "left":
                this.position[1]++;
                break;
            case "right":
                this.position[1]--;
                break;
            default:
                System.out.println("Ação inválida!");
        }
    }

    public abstract void move(int comand);
}
