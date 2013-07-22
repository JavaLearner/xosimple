package com.game.xo.common;


public class CreateGame {
    private static final int AMOUNT_CELLS = 3;
    private char gameArray[][] = new char[AMOUNT_CELLS][AMOUNT_CELLS];

    public CreateGame() {
        initialArray();
    }

    private void initialArray() {
        for (int i = 0; i < AMOUNT_CELLS; i++) {
            initialLine(i);
        }
    }

    private void initialLine(int axisX) {
        for (int j = 0; j < AMOUNT_CELLS; j++) {
            gameArray[axisX][j] = ' ';
        }
    }

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
