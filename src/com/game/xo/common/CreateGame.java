package com.game.xo.common;


import java.util.Scanner;

public class CreateGame {
    private static final int AMOUNT_CELLS = 3;
    private char gameArray[][] = new char[AMOUNT_CELLS][AMOUNT_CELLS];
    private static final char DEFAULT_SYMBOL = ' ';
    private static final char SYMBOL_X = 'x';
    private static final char SYMBOL_0 = '0';
    private int globalStepCount = 0;
    private int axisX, axisY;

    private Scanner myScanner = new Scanner(System.in);
    LogicAlgorithm myAlgorithm = new LogicAlgorithm();

    public CreateGame() {

        initialArray();

    }

    public char getSymbolX() {
        return SYMBOL_X;
    }

    public char getSymbol0() {
        return SYMBOL_0;
    }

    public char getDefaultSymbol() {
        return DEFAULT_SYMBOL;
    }

    public void setGlobalStepCount(int globalStepCount) {
        this.globalStepCount = globalStepCount;
    }

    public int getGlobalStepCount() {
        return globalStepCount;
    }

    /* initialisation of game field  */
    private void initialArray() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            initialLine(i);
        }
    }

    private void initialLine(int axisX) {
        for (int j = 0; j < AMOUNT_CELLS; j++) {
            gameArray[axisX][j] = DEFAULT_SYMBOL;
        }
    }

    /* display game field*/
    public void viewArray() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            viewLine(i);
            System.out.println();
        }

    }

    public void viewLine(int axisX) {
        for (int j = 0; j < AMOUNT_CELLS; j++) {
            if (gameArray[axisX][j] == ' ') {
                System.out.print("(" + axisX + "," + j + ") ");
            } else {
                System.out.print("  " + gameArray[axisX][j] + "   ");
            }
        }

    }

    /*set new step in game field*/
    public void gameStep(char playerSymbol1, char playerSymbol2, boolean flagError) {
        while (flagError) {
            System.out.print("Enter coordinate (x, ): ");
            axisX = myScanner.nextInt();
            System.out.print("Enter coordinate ( ,y): ");
            axisY = myScanner.nextInt();

            //add - view game field if entered the same symbol in cell
            try {
                if ((playerSymbol1 == SYMBOL_X)||(playerSymbol2 == SYMBOL_X) && (gameArray[axisX][axisY] == DEFAULT_SYMBOL)) {
                    flagError = checkWin(SYMBOL_X, flagError);
                } else {
                    if (gameArray[axisX][axisY] == DEFAULT_SYMBOL) {
                        myAlgorithm.searchWinner(gameArray, SYMBOL_0);
                        gameArray[axisX][axisY] = SYMBOL_0;
                        flagError = addition(flagError);
                    }

                }

            } catch (ArrayIndexOutOfBoundsException e)

            {
                System.out.println("Your coordinates invalid.\nPlease enter correct coordinates.");
                viewArray();
                flagError = true;
            }
        }
        flagError = checkWin(chosenSymbol, flagError);


    }

    private boolean checkWin(char symbol, boolean flagError) {
        if (!myAlgorithm.searchWinner(gameArray, symbol)) {
            gameArray[axisX][axisY] = symbol;
            flagError = addition(flagError);
        } else {
            setGlobalStepCount((int) Math.pow(AMOUNT_CELLS, 2));
            System.out.println("\nYou win\n");
            flagError = false;
        }
        return flagError;
    }

    private boolean addition(boolean flagError) {
        if (flagError) {
            globalStepCount++;
        }
        flagError = false;
        return flagError;

    }
}
