package com.game.xo.field;


import com.game.xo.display.ConsoleDisplay;

public class ConsoleField {
    private final char EMPTY_CELL = ' ';
    private static final int AMOUNT_CELLS = 3;
    private char gameField[][] = {{EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
            {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}, {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}};


    public boolean setGameField(int axisX, int axisY, char symbol) {
        //add try/catch
        try {
            gameField[axisX][axisY] = symbol;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public char getGameField(int axisX, int axisY) {
        return gameField[axisX][axisY];

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
