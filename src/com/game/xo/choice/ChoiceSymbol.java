package com.game.xo.choice;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Player;

public class ChoiceSymbol {
    ConsoleDisplay consoleDisplay = new ConsoleDisplay();
    InputDataString inputDataString = new InputDataString();

    public void chooseSymbol(Player player1, Player player2) {
        consoleDisplay.displayMessage("Choose symbol x or o : ");
        String choiceString = inputDataString.getData();
        switch (checkChoice(choiceString.charAt(0))) {
            case 'x':
                player1.setPlayerSymbol('x');
                player2.setPlayerSymbol('0');
                break;
            case '0':
                player2.setPlayerSymbol('x');
                player1.setPlayerSymbol('0');
                break;
            default:
                consoleDisplay.displayMessage("Invalid option.\n");
                break;
        }
    }
    private char checkChoice(char inputChar) {
        if (inputChar == 'x' || inputChar == 'X') {
            return 'x';
        }
        if (inputChar == '0' || inputChar == 'o' || inputChar == 'O') {
            return '0';
        }
        return 'e';

    }
}
