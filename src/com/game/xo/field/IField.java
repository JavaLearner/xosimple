package com.game.xo.field;


import com.game.xo.display.IDisplay;
import com.game.xo.players.Player;

public interface IField {
    public boolean setGameField(Player player, IDisplay display);

    public char getGameField(Player player);

    public void displayField();
}
