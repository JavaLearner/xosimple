package com.game.xo.players;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.input.InputDataString;


public class KindPlayer implements IKindPlayer {


    private InputDataString inputData = new InputDataString();
    private ConsoleDisplay consoleDisplay = new ConsoleDisplay();
    private boolean kind;

    public boolean getKind() {
        return kind;
    }

    public Player chooseKind() {
       boolean flag = false;

        while (!flag) {
        consoleDisplay.displayMessage("You play with human or computer? h/c: ");
            String inputString = inputData.getData();
        if (inputString.charAt(0) == 'h' || inputString.charAt(0) == 'H') {
            consoleDisplay.displayMessage("Enter player name: ");
            inputString = inputData.getData();
            kind = true;
            return new Human(inputString);

        } else {
            if (inputString.charAt(0) == 'c' || inputString.charAt(0) == 'C') {
                kind = false;

                return new Computer();
            } else {
                consoleDisplay.displayMessage("Invalid option!!! Try again.\n");

            }
        }
    }
        return null;

    }

}
