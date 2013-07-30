package com.game.xo.common;

import com.game.xo.players.Player;

import java.util.Scanner;

public class GameProcess {
    private static final int AMOUNT_CELLS = 3;
    private char gameField[][] = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    public final char EMPTY_CELL = ' ';
    public final char SYMBOL_X = 'x';
    public final char SYMBOL_0 = '0';
    private int globalStepCount;
    private int axisX;
    private int axisY;

    private Scanner scanner = new Scanner(System.in);
    private SearchWinner searchWinner = new SearchWinner();

    public GameProcess() {
        globalStepCount = 0;
    }

    public void setGlobalStepCount(int globalStepCount) {
        if (globalStepCount >= 0 && globalStepCount < 9) {
            this.globalStepCount = globalStepCount;
        }
    }

    public int getGlobalStepCount() {
        return globalStepCount;
    }

    public void displayGameField() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            displayGameFieldSub(i);
            System.out.println();
        }
        System.out.println();
    }

    private void displayGameFieldSub(int axisX) {
        for (int j = 0; j < AMOUNT_CELLS; j++) {
            if (gameField[axisX][j] == EMPTY_CELL) {
                System.out.print("(" + axisX + "," + j + ") ");
            } else {
                System.out.print("  " + gameField[axisX][j] + "   ");
            }
        }

    }

    public void gameMovies(Player player, boolean flagError) {
        while (flagError && !player.getYouWin()) {
            getPlayerStep();
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
                displayGameField();
                flagError = true;
            }
        }
        flagError = checkWin(player, flagError);


    }

    private void getPlayerStep() {
        System.out.print("Enter coordinate (x, ): ");
        axisX = scanner.nextInt();
        System.out.print("Enter coordinate ( ,y): ");
        axisY = scanner.nextInt();
    }

    private boolean checkWin(Player player, boolean flagError) {
        if (!searchWinner.searchWinner(gameField, player.getPlayerSymbol())) {
            gameField[axisX][axisY] = player.getPlayerSymbol();
            flagError = updateFields(flagError, player);
        } else {
            System.out.println("\n" + player.getName() + " you win!!!\n");
            player.setYouWin(true);
            flagError = false;
        }
        return flagError;
    }

    private boolean updateFields(boolean flagError, Player player) {
        if (flagError) {
            globalStepCount++;
            player.setPlayerSteps(globalStepCount);
        }
        flagError = false;
        return flagError;

    }
}
