package com.game.xo.field;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.display.IDisplay;
import com.game.xo.players.Player;

public class ConsoleField implements IField {
    private final char EMPTY_CELL = ' ';
    private static final int AMOUNT_CELLS = 3;
    private char gameField[][] = {{EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
            {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}, {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}};
    private IDisplay display;

//   public ConsoleField(IDisplay display){
//       this.display = display;
//
//   }


    public boolean setGameField(Player player, IDisplay display) {
        try {
            if (gameField[player.getAxisX()][player.getAxisY()] == ' ') {
                gameField[player.getAxisX()][player.getAxisY()] = player.getPlayerSymbol();
            } else {
                display.displayMessage("The cell not empty. Choose another one.");
                return false;
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            display.displayMessage("Invalid coordinates. Choose again: ");
            return false;
        }
    }


    public char getGameField(Player player) {
        return gameField[player.getAxisX()][player.getAxisY()];

    }


    public void displayField() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            displayFieldSub(i);
            System.out.println();
        }
        System.out.println();
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
