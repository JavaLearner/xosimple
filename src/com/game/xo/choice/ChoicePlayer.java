package com.game.xo.choice;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Computer;
import com.game.xo.players.Human;
import com.game.xo.players.Player;


public class ChoicePlayer implements IChoicePlayer {
    private static int counter = 1;
    private static int numberHumanPlayers = 0;
    private static int numberComputerPlayers = 0;

    ConsoleDisplay consoleDisplay = new ConsoleDisplay();
    InputDataString inputDataString = new InputDataString();

    public Player choosePlayer() {
        consoleDisplay.displayMessage("Choose player human or computer - h/c: ");
        String choiceString = inputDataString.getData();
        switch (checkChoice(choiceString.charAt(0))) {
            case 'h':
                numberHumanPlayers++;
                return new Human(getPlayerName());
            case 'c':
                numberComputerPlayers++;
                    if(numberHumanPlayers == 0 && numberComputerPlayers != 1){
                        return new Computer(2);
                    }
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
