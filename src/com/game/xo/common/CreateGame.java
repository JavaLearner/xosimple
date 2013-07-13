package com.game.xo.common;


public class CreateGame {
    private final int AMOUNT_CELLS = 3;
    private char gameArray[][] = new char[AMOUNT_CELLS][AMOUNT_CELLS];

    public CreateGame() {
        initialArray();
    }

    private void initialArray() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            for (int j = 0; j < AMOUNT_CELLS; j++) {
                gameArray[i][j] = ' ';
            }
        }
    }

    public void viewArray() {
        LogicAlgorithm newGame = new LogicAlgorithm(gameArray, AMOUNT_CELLS);

        for (int i = 0; i < AMOUNT_CELLS; i++) {
            for (int j = 0; j < AMOUNT_CELLS; j++) {
                if (gameArray[i][j] == ' ') {
                    System.out.print("(" + i + "," + j + ") " );
                } else {
                    System.out.print("  " + gameArray[i][j] + "   ");

                }
            }
            System.out.println();
        }

    }

    public void step(int axisX, int axisY, int chosenSymbol) {
        //add try/catch
        try {
            if (chosenSymbol == 1) {
                gameArray[axisX][axisY] = 'x';
            } else {
                gameArray[axisX][axisY] = '0';

            }
        } catch (ArrayIndexOutOfBoundsException e)

        {
            System.out.println("Your coordinates invalid.");
        }
    }

    /*public boolean checking() {

    }  */
}
