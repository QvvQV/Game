package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new NotRegisteredException(playerName);
    }

    public int round(String playerName1, String playerName2) {
        int strenghtPlayer1 = findByName(playerName1).getStrength();
        int strenghtPlayer2 = findByName(playerName2).getStrength();
        if (strenghtPlayer2 > strenghtPlayer1) {
            return 2;
        } else if (strenghtPlayer2 < strenghtPlayer1) {
            return 1;
        }
        return 0;
    }
}