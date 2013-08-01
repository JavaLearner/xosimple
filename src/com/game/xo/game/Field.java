package com.game.xo.game;

import com.game.xo.players.Player;

import java.util.Scanner;

public class Field {
    private final char EMPTY_CELL = ' ';
    private static final int AMOUNT_CELLS = 3;
    private char gameField[][] = {{EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
            {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}, {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}};



    public void setGameField(int axisX, int axisY, char symbol) {
        //add try/catch
        gameField[axisX][axisY] = symbol;
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
