package com.game.xo.choice;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Computer;
import com.game.xo.players.Human;
import com.game.xo.players.Player;


public class ChoicePlayer implements IChoicePlayer {


    ConsoleDisplay consoleDisplay = new ConsoleDisplay();
    InputDataString inputDataString = new InputDataString();

    public Player setFirstPlayer() {
        return new Human(getPlayerName());
    }
    public Player choosePlayer() {
        consoleDisplay.displayMessage("Choose second player. Human or Computer - h/c: ");
        String choiceString = inputDataString.getData();
        switch (checkChoice(choiceString.charAt(0))) {
            case 'h':
                return new Human(getPlayerName());
            case 'c':
                return new Computer();

            default:
                consoleDisplay.displayMessage("Invalid option.\n");
                return null;
        }
    }

    private String getPlayerName() {
        String name;
        consoleDisplay.displayMessage("Enter your name: ");
        name = inputDataString.getData();
        return name;
    }

    private char checkChoice(char inputChar) {
        if (inputChar == 'h' || inputChar == 'H') {
            return 'h';
        }
        if (inputChar == 'c' || inputChar == 'C') {
            return 'c';
        }
        return 'e';

    }
}
