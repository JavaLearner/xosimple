package com.game.xo.players;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.input.InputDataNumber;
import com.game.xo.input.InputDataString;


public class KindPlayer implements IKindPlayer {


    private InputDataString inputData = new InputDataString();
    private ConsoleDisplay consoleDisplay = new ConsoleDisplay();
    private boolean kind;

    private enum GameMode {
        HUMAN, COMPUTER, ERROR
    }

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
                //add flag or something to indicate who play!!!
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

    public GameMode chooseMode(Player player) {

        if (player instanceof Human) {
            return GameMode.HUMAN;
        } else {

            return GameMode.COMPUTER;
        }

    }

    public boolean getPlayerMove(Player player, int tempX, int tempY, int size) {
        InputDataNumber inputDataNumber = new InputDataNumber();
        GameMode mode = chooseMode(player);
        switch (mode) {
            case HUMAN:

                consoleDisplay.displayMessage("\nEnter coordinate (x, ): ");
                player.setAxisX(inputDataNumber.getNumber());
                consoleDisplay.displayMessage("Enter coordinate ( ,y): ");
                player.setAxisY(inputDataNumber.getNumber());
                return true;

            case COMPUTER:
                Computer computer = (Computer) player;
                if (computer.setFirstSymbol(size, tempX, tempY)) {
                    return true;
                }
                return false;
            default:
                return false;
        }

    }

}
