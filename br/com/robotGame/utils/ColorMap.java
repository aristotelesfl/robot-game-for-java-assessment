package br.com.robotGame.utils;

public class ColorMap {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CIANO = "\u001B[36m";

    public static String colorMap(String cor, String texto) {
        String colorCode = switch (cor.toLowerCase()) {
            case "vermelho" -> RED;
            case "verde" -> GREEN;
            case "amarelo" -> YELLOW;
            case "azul" -> BLUE;
            case "ciano" -> CIANO;
            default -> throw new IllegalArgumentException("Erro: Cor Inválida! Tente novamente.");
        };

        return colorCode + texto + RESET;
    }
}
