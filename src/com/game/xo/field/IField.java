package com.game.xo.field;


import com.game.xo.display.IDisplay;
import com.game.xo.players.Player;

public interface IField {
    public boolean setGameField(Player player, IDisplay display);

    public void clearField();

    public char getGameField(int axisX, int axisY);

    public void displayField();
    public void returnBack();
}
