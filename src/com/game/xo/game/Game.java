package com.game.xo.game;

import com.game.xo.choice.ChoiceSymbol;
import com.game.xo.display.ConsoleDisplay;
import com.game.xo.field.ConsoleField;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Player;

public class Game implements IGame {
    private Player player1;
    private Player player2;
    private ConsoleField field;
    private InputDataString inputDataString = new InputDataString();
    private ConsoleDisplay consoleDisplay = new ConsoleDisplay();
    private boolean endOfGame;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

    }

    public void startGame() {
        ChoiceSymbol choiceSymbol = new ChoiceSymbol();

        //do{
        consoleDisplay.displayMessage("Game start.\n");
        choiceSymbol.chooseSymbol(player1, player2);
        consoleDisplay.displayMessage(player1.getName() + " your symbol : " + player1.getPlayerSymbol() + "\n");
        consoleDisplay.displayMessage(player2.getName() + " your symbol : " + player2.getPlayerSymbol() + "\n");
        ConsoleField field = new ConsoleField();
        consoleDisplay.displayMessage("\n");
        field.displayField();
        //}while(endOfGame);


    }

}