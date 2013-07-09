package com.game.xo.common;


public class CreateGame {
    private final int AMOUNT_CELLS = 3;
    private int gameArray[][] = new int[AMOUNT_CELLS][AMOUNT_CELLS];

    public CreateGame() {
        initialArray();
    }

    private void initialArray() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            for (int j = 0; j < AMOUNT_CELLS; j++) {
                gameArray[i][j] = -1;
            }
        }
    }

    public void viewArray() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            for (int j = 0; j < AMOUNT_CELLS; j++) {
                System.out.print(gameArray[i][j]);
            }
            System.out.println();
        }
    }

    public void step(int axisX , int axisY) {
        //add try/catch
        gameArray [axisX][axisY] = 1;

    }

    /*public boolean checking() {

    }  */
}
