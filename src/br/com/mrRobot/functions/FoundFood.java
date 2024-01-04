package br.com.mrRobot.functions;

import br.com.mrRobot.models.Player;

import java.util.Arrays;

public class FoundFood {
    public boolean foundFood(Player player, int[] positionFood) {
        if (Arrays.equals(player.getPosition(), positionFood)) {
            return true;
        }else {
            return false;
        }
    }
}
