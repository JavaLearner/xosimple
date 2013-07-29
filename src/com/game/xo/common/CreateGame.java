package com.game.xo.common;

import com.game.xo.players.Player;

import java.util.Scanner;

public class CreateGame {
    private static final int AMOUNT_CELLS = 3;
    private char gameField[][] = new char[AMOUNT_CELLS][AMOUNT_CELLS];
    private static final char DEFAULT_SYMBOL = ' ';
    private static final char SYMBOL_X = 'x';
    private static final char SYMBOL_0 = '0';
    private int globalStepCount;
    private int axisX, axisY;

    private Scanner myScanner = new Scanner(System.in);
    LogicAlgorithm myAlgorithm = new LogicAlgorithm();

    public enum Symbols {

    }
    public CreateGame() {

        initialArray();
        globalStepCount = 0;
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
            initializeGameFieldSub(i);
        }
    }

    private void initializeGameFieldSub(int axisX) {
        for (int j = 0; j < AMOUNT_CELLS; j++) {
            gameField[axisX][j] = DEFAULT_SYMBOL;
        }
    }

    /* display game field*/
    public void viewGameField() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            viewGameFieldSub(i);
            System.out.println();
        }
        System.out.println();
    }

    private void viewGameFieldSub(int axisX) {
        for (int j = 0; j < AMOUNT_CELLS; j++) {
            if (gameField[axisX][j] == DEFAULT_SYMBOL) {
                System.out.print("(" + axisX + "," + j + ") ");
            } else {
                System.out.print("  " + gameField[axisX][j] + "   ");
            }
        }

    }

    /*set new step in game field*/
    public void gameStep(Player player, boolean flagError) {
        while (flagError && !player.getYouWin()) {
            playerStep();
            try {
                if ((player.getPlayerSymbol() == SYMBOL_X) && (gameField[axisX][axisY] == DEFAULT_SYMBOL)) {
                    flagError = checkWin(player, flagError);
                } else {
                    if (gameField[axisX][axisY] == DEFAULT_SYMBOL) {
                        flagError = checkWin(player, flagError);
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e)

            {
                System.out.println("Your coordinates invalid.\nPlease enter correct coordinates.");
                viewGameField();
                flagError = true;
            }
        }
        flagError = checkWin(player, flagError);


    }

    private void playerStep() {
        System.out.print("Enter coordinate (x, ): ");
        axisX = myScanner.nextInt();
        System.out.print("Enter coordinate ( ,y): ");
        axisY = myScanner.nextInt();
    }

    private boolean checkWin(Player player, boolean flagError) {
        if (!myAlgorithm.searchWinner(gameField, player.getPlayerSymbol())) {
            gameField[axisX][axisY] = player.getPlayerSymbol();
            flagError = addition(flagError, player);
        } else {
            System.out.println("\n" + player.getName() + " you win!!!\n");
            player.setYouWin(true);
            flagError = false;
        }
        return flagError;
    }

    private boolean addition(boolean flagError, Player player) {
        if (flagError) {
            globalStepCount++;
            player.setPlayerSteps(globalStepCount);
        }
        flagError = false;
        return flagError;

    }
}
