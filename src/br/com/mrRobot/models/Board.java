package br.com.mrRobot.models;
import java.util.Arrays;
import br.com.mrRobot.functions.ColorMap;

public class Board{
    public void generateBoard(Player player, int[] positionFood){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                int[] position = {i, j};
                if(Arrays.equals(player.getPosition(), position)) {
                    System.out.print(ColorMap.colorMap(player.getColor(), "(  R  )"));
                } else if (Arrays.equals(positionFood, position)) {
                    System.out.print(ColorMap.colorMap("amarelo", "(  A  )" ));
                } else {
                    System.out.printf("(%d , %d)", i, j);
                }
                if(j<4){
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
}
