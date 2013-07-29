package com.game.xo.common;

import com.game.xo.players.Player;

import java.util.Scanner;

public class InitializeGame {
    private static final int AMOUNT_CELLS = 3;
    private char gameField[][] = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static final char EMPTY_CELL = ' ';
    private static final char SYMBOL_X = 'x';
    private static final char SYMBOL_0 = '0';
    private int globalStepCount;
    private int axisX, axisY;

    private Scanner scanner = new Scanner(System.in);
    private GameAlgorithm newGame = new GameAlgorithm();

    public InitializeGame() {
        globalStepCount = 0;
    }

    public char getSymbolX() {
        return SYMBOL_X;
    }

    public char getSymbol0() {
        return SYMBOL_0;
    }

    public char getDefaultSymbol() {
        return EMPTY_CELL;
    }

    public void setGlobalStepCount(int globalStepCount) {
        if (globalStepCount >= 0 && globalStepCount < 9) {
            this.globalStepCount = globalStepCount;
        }
    }

    public int getGlobalStepCount() {
        return globalStepCount;
    }

    public void viewGameField() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            viewGameFieldSub(i);
            System.out.println();
        }
        System.out.println();
    }

    private void viewGameFieldSub(int axisX) {
        for (int j = 0; j < AMOUNT_CELLS; j++) {
            if (gameField[axisX][j] == EMPTY_CELL) {
                System.out.print("(" + axisX + "," + j + ") ");
            } else {
                System.out.print("  " + gameField[axisX][j] + "   ");
            }
        }

    }

    public void gameStep(Player player, boolean flagError) {
        while (flagError && !player.getYouWin()) {
            playerStep();
            try {
                if ((player.getPlayerSymbol() == SYMBOL_X) && (gameField[axisX][axisY] == EMPTY_CELL)) {
                    flagError = checkWin(player, flagError);
                } else {
                    if (gameField[axisX][axisY] == EMPTY_CELL) {
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
        axisX = scanner.nextInt();
        System.out.print("Enter coordinate ( ,y): ");
        axisY = scanner.nextInt();
    }

    private boolean checkWin(Player player, boolean flagError) {
        if (!newGame.searchWinner(gameField, player.getPlayerSymbol())) {
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
