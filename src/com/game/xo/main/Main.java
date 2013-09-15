package com.game.xo.main;


import com.game.xo.choice.ChoicePlayer;
import com.game.xo.choice.ChoiceSymbol;
import com.game.xo.display.ConsoleDisplay;
import com.game.xo.display.IDisplay;
import com.game.xo.field.ConsoleField;
import com.game.xo.players.Player;
import com.game.xo.game.Game;

/**
 * Created with IntelliJ IDEA.
 * User: JL Junior
 * Date: 7/9/13
 * Time: 10:30 PM
 * simple game "Tic Tac Toe" for console
 */
public class Main {
    public static void main(String[] args) {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay();
        ConsoleField consoleField = new ConsoleField(consoleDisplay);
        boolean choiceFlag = true;
        ChoicePlayer choicePlayer = new ChoicePlayer();
        ChoiceSymbol choiceSymbol = new ChoiceSymbol();
        consoleDisplay.displayMessage("Game start.\n");
        do {
            Player firstPlayer = choicePlayer.setFirstPlayer();

            if (firstPlayer != null) {
                do {
                    Player secondPlayer = choicePlayer.choosePlayer();

                    if (secondPlayer != null) {
                        choiceSymbol.chooseSymbol(firstPlayer, secondPlayer);
                        Game game = new Game(firstPlayer, secondPlayer, consoleDisplay, consoleField);
                        game.startGame();
                        choiceFlag = false;
                    }
                } while (choiceFlag);
            }

        } while (choiceFlag);

    }


}



