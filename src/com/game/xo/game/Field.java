package com.game.xo.game;


public class Field {
    private final char EMPTY_CELL = ' ';
    private static final int AMOUNT_CELLS = 3;
    private char gameField[][] = {{EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
            {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}, {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}};



    public boolean setGameField(int axisX, int axisY, char symbol) {
        //add try/catch
        try{
        gameField[axisX][axisY] = symbol;
            return  true;
        }
        catch(ArrayIndexOutOfBoundsException e) {
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
        for (int j = 0; j < AMOUNT_CELLS; j++) {
            if (gameField[axisX][j] == EMPTY_CELL) {
                System.out.print("(" + axisX + "," + j + ") ");
            } else {
                System.out.print("  " + gameField[axisX][j] + "   ");
            }
        }

    }


}
