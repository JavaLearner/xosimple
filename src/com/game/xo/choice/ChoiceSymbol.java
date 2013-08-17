package com.game.xo.choice;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Human;
import com.game.xo.players.Player;

public class ChoiceSymbol implements  IChoiceSymbol{
    ConsoleDisplay consoleDisplay = new ConsoleDisplay();
    InputDataString inputDataString = new InputDataString();

    public void chooseSymbol(Player player1, Player player2) {
        boolean choiceFlag = true;

        if(player1 instanceof Human || player2 instanceof Human) {
        while (choiceFlag){
        consoleDisplay.displayMessage("Choose symbol x or o : ");
        String choiceString = inputDataString.getData();
        switch (checkChoice(choiceString.charAt(0))) {
            case 'x':
                setSymbol(player1, player2);
                choiceFlag = false;
                break;
            case '0':
                setSymbol(player2, player1);
                choiceFlag = false;
                break;
            default:
                consoleDisplay.displayMessage("Invalid option.\n");
                break;
        }
        }
        }else {

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
    private void setSymbol(Player player1, Player player2) {
        player1.setPlayerSymbol('x');
        player2.setPlayerSymbol('0');
    }
}
