package com.game.xo.choice;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Computer;
import com.game.xo.players.Human;
import com.game.xo.players.Player;


public class Choice implements  IChoice{
    ConsoleDisplay consoleDisplay = new ConsoleDisplay();
    InputDataString inputDataString = new InputDataString();

    public Player choosePlayer() {
        consoleDisplay.displayMessage("Choose player human or computer - h/c: ");
        String choiceString = inputDataString.getData();
        switch(choiceString.charAt(0)){
            case 'h':
                return new Human(getPlayerName());
            case 'c':
                return new Computer();
            default:
                return null;
        }
    }

    private String getPlayerName(){
        String name;
        consoleDisplay.displayMessage("Enter your name: ");
        name = inputDataString.getData();
        return name;
    }
}
