package br.com.mrRobot.models;

public abstract class Robot {
    private final String color;
    private int[] position = new int[2];

    public Robot(String color){
        this.color = color;
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
        switch (comand.toLowerCase()) {
            case "up" -> this.position[0]--;
            case "down" -> this.position[0]++;
            case "left" -> this.position[1]--;
            case "right" -> this.position[1]++;
            default -> System.out.println("Ação inválida!");
        }
    }

    public abstract void move(int comand);
}
