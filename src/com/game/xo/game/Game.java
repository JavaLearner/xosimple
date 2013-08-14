package com.game.xo.game;

import com.game.xo.display.ConsoleDisplay;
import com.game.xo.field.ConsoleField;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Player;

public class Game {
    private Player player1;
    private Player player2;
    private ConsoleField field;
    private InputDataString inputDataString;
    private ConsoleDisplay consoleDisplay;

    public  Game(Player player1, Player player2, ConsoleField field) {
       this.player1 = player1;
       this.player2 = player2;
       this.field = field;
    }

    public void startGame() {
        consoleDisplay.displayMessage("Game start.");


    }

}