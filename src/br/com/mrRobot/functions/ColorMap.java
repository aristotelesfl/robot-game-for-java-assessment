package br.com.mrRobot.functions;
import java.util.HashMap;
import java.util.Map;

public class ColorMap {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CIANO = "\u001B[36m";

    public static final Map<String, String> CORES = new HashMap<>();

    static {
        CORES.put("vermelho", RED);
        CORES.put("verde", GREEN);
        CORES.put("amarelo", YELLOW);
        CORES.put("azul", BLUE);
        CORES.put("ciano", CIANO);
    }

    public static void colorMap(String cor, String texto) {
        if (CORES.containsKey(cor)) {
            System.out.print(CORES.get(cor) + texto + RESET);
        } else {
            System.out.print("Cor não encontrada: " + cor);
        }
    }
}
