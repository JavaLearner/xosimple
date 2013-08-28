package com.game.xo.field;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.display.IDisplay;
import com.game.xo.players.Player;

public class ConsoleField implements IField {
    private final char EMPTY_CELL = ' ';
    private static final int AMOUNT_CELLS = 3;
    private char gameField[][] = new char[AMOUNT_CELLS][AMOUNT_CELLS];
    private IDisplay display;

    public ConsoleField(IDisplay display) {
        this.display = display;
        clearField();

    }
     //refactoring!!!!!!!!
    public void clearField() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                gameField[i][j] = EMPTY_CELL;
            }
        }
    }

    public boolean setGameField(Player player, IDisplay display) {
        try {
            if (gameField[player.getAxisX()][player.getAxisY()] == EMPTY_CELL) {
                gameField[player.getAxisX()][player.getAxisY()] = player.getPlayerSymbol();
            } else {
                display.displayMessage("The cell not empty. Choose another one.");
                return false;
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            display.displayMessage("Invalid coordinates. Choose again.\n");
            return false;
        }
    }


    public char getGameField(Player player) {
        return gameField[player.getAxisX()][player.getAxisY()];

    }


    public void displayField() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            displayFieldSub(i);
            display.displayMessage("\n");
        }
        display.displayMessage("\n");
    }

    private void displayFieldSub(int axisX) {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay();

        for (int j = 0; j < AMOUNT_CELLS; j++) {
            if (gameField[axisX][j] == EMPTY_CELL) {
                consoleDisplay.displayMessage("(" + axisX + "," + j + ") ");
            } else {
                consoleDisplay.displayMessage("  " + gameField[axisX][j] + "   ");
            }
        }

    }


}
