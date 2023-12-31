package br.com.mrRobot.models;
import java.util.Arrays;
import br.com.mrRobot.functions.ColorMap;

public class Board{
    public void generateBoard(Player player, int[] food){
        for(int i=0; i<6; i++){
            //            manda pra outro canto
//            if (Arrays.equals(player.getPosition(), food)) {
//                player.gameEnd(true);
//                System.out.println("cabou");
//                break;
//            }
            for(int j=0; j<6; j++){
                int[] position = {i, j};
                if(Arrays.equals(player.getPosition(), position)) {
                    ColorMap.colorMap(player.getColor(), "(  R  )");
                } else if (Arrays.equals(food, position)) {
                    ColorMap.colorMap("ciano", "(  A  )" );
                } else {
                    System.out.printf("(%d , %d)", i, j);
                }
                if(j<5){
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
}
