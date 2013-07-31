package com.game.xo.game;

import com.game.xo.players.*;

import java.util.Scanner;

public class Game {
    public final int MAX_STEPS = 9;
    private final char HUMAN_PLAY = 'h';
    private final char COMPUTER_PLAY = 'c';
    public final char EMPTY_CELL = ' ';
    public final char SYMBOL_X = 'x';
    public final char SYMBOL_0 = '0';
    private int globalStepCount;
    private int axisX;
    private int axisY;
    private int findWinner;
    private static final int WINS = 3;
    private Scanner in = new Scanner(System.in);
    private Field field;

    public void Game() {
        boolean flagError = true;//false when no errors
        boolean endOfGameFlag = true;//false if exit from game
        String continueGame;
        String namePlayer;
        String chosenSymbol;
        String tempOption;
        char chosenOption;

        while (endOfGameFlag) {
            field = new Field();

            viewMessage("Field start.\n");

            viewMessage("Enter first name: ");
            namePlayer = in.nextLine();
            Player firstPlayer = new Human(namePlayer);
            Player secondPlayer = new Player();

            //check creation second player????????
            do {
                viewMessage("You play with human or computer? h/c: ");
                tempOption = in.nextLine();
                chosenOption = whatChosen(tempOption);
                switch (chosenOption) {
                    case COMPUTER_PLAY:
                        secondPlayer = new Computer();

                        break;
                    case HUMAN_PLAY:
                        viewMessage("Enter second name: ");
                        namePlayer = in.nextLine();
                        secondPlayer = new Human(namePlayer);
                        break;
                    default:
                        viewMessage("Invalid option!!! Try again.");
                        flagError = false;
                        break;
                }
            } while (!flagError);
            field.displayField();
            flagError = true;

            do {
                viewMessage(firstPlayer.getName() + "\nChoose your symbol x or 0 : ");
                chosenSymbol = in.nextLine();
                switch (chosenSymbol.charAt(0)) {
                    case '0':
                        setSymbol(firstPlayer, secondPlayer, field);
                        break;
                    case 'x':
                        setSymbol(secondPlayer, firstPlayer, field);
                        break;
                    default:
                        viewMessage("Invalid option!!! Try again.");
                        flagError = false;
                        break;
                }
            } while (!flagError);
            while (!firstPlayer.getYouWin() && !secondPlayer.getYouWin() && secondPlayer.getPlayerSteps() < MAX_STEPS) {
                viewMessage(firstPlayer.getName() + " your turn. Your symbol: " + firstPlayer.getPlayerSymbol());
                gameMovies(firstPlayer, flagError);
                field.displayField();
                if (firstPlayer.getYouWin()) {
                    break;
                }
                if (firstPlayer.getPlayerSteps() >= MAX_STEPS) {
                    viewMessage("\nStandoff");
                    break;
                }
                viewMessage(secondPlayer.getName() + " your turn. Your symbol: " + secondPlayer.getPlayerSymbol());
                field.gameMovies(secondPlayer, flagError);
                field.displayField();

            }

            viewMessage("Start the new game? y/n: ");
            continueGame = in.nextLine();

            flagError = false;
            while (!flagError) {
                if (continueGame.charAt(0) == 'y' || continueGame.charAt(0) == 'Y') {
                    endOfGameFlag = true;
                } else {
                    if (continueGame.charAt(0) == 'n' || continueGame.charAt(0) == 'N') {
                        endOfGameFlag = false;
                    } else {
                        viewMessage("Invalid option!!! Try again.");

                    }
                }
                flagError = true;
            }

        }

        viewMessage("\nEnd of game...");
        in.nextLine();
    }

    public void gameMovies(Player player, boolean flagError) {
        while (flagError && !player.getYouWin()) {
            getPlayerStep();
            try {
                if ((player.getPlayerSymbol() == SYMBOL_X) && (field.getFieldCell(axisX, axisY) == EMPTY_CELL)) {
                    flagError = checkWin(player, flagError);
                } else {
                    if (field.getFieldCell(axisX, axisY) == EMPTY_CELL) {
                        flagError = checkWin(player, flagError);
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e)

            {
                System.out.println("Your coordinates invalid.\nPlease enter correct coordinates.");
                field.displayField();
                flagError = true;
            }
        }
        flagError = checkWin(player, flagError);


    }

    //add - when play computer
    private void getPlayerStep() {
        System.out.print("Enter coordinate (x, ): ");
        axisX = in.nextInt();
        System.out.print("Enter coordinate ( ,y): ");
        axisY = in.nextInt();
    }

    private boolean checkWin(Player player, boolean flagError) {
        if (!searchWinner.searchWinner(gameField, player.getPlayerSymbol())) {
            gameField[axisX][axisY] = player.getPlayerSymbol();
            flagError = updates(flagError, player);
        } else {
            System.out.println("\n" + player.getName() + " you win!!!\n");
            player.setYouWin(true);
            flagError = false;
        }
        return flagError;
    }

    private boolean updates(boolean flagError, Player player) {
        if (flagError) {
            globalStepCount++;
            player.setPlayerSteps(globalStepCount);
        }
        flagError = false;
        return flagError;

    }

    private void setSymbol(Player player1, Player player2, Field newField) {
        player1.setPlayerSymbol(newField.SYMBOL_0);
        player2.setPlayerSymbol(newField.SYMBOL_X);

    }

    private void viewMessage(String string) {
        System.out.println(string);
    }

    private char whatChosen(String chosen) {
        if (chosen.charAt(0) == HUMAN_PLAY || chosen.charAt(0) == 'H') {
            return HUMAN_PLAY;
        } else {
            if (chosen.charAt(0) == COMPUTER_PLAY || chosen.charAt(0) == 'C') {
                return COMPUTER_PLAY;
            }
        }
        return 'e';
    }

    public boolean searchWinner(char symbol) {
        if (rowWinner(symbol) || columnWinner(symbol) || diagonalWinner(symbol)) {
            return true;
        } else {
            return false;
        }
    }

    /*search winner in rows*/
    private boolean rowWinner(char symbol) {

        for (int i = 0; i < tempField.length; i++) {
            findWinner = rowWinnerSub(i, tempField.length, symbol);
            if (findWinner == WINS) {
                return true;
            }
        }
        return false;
    }

    private int rowWinnerSub(int axisX, int size, char symbol) {
        int sum = 0;
        for (int j = 0; j < size; j++) {
            if (field.getFieldCell(axisX, j) == symbol) {
                sum++;
            }
        }
        return sum;
    }

    /*search winner in columns*/
    private boolean columnWinner(char symbol) {
        for (int i = 0; i < tempField.length; i++) {
            findWinner = columnWinnerSub(i, tempField.length, symbol);
            if (findWinner == WINS) {
                return true;
            }
        }
        return false;
    }

    private int columnWinnerSub(int axisY, int size, char symbol) {
        int sum = 0;
        for (int j = 0; j < size; j++) {
            if (tempField[j][axisY] == symbol) {
                sum++;
            }
        }
        return sum;
    }

    /*search winner in diagonals*/
    private boolean diagonalWinner(char symbol) {
        int i, sum = 0;
        for (i = 0; i < tempField.length; i++) {
            if (tempField[i][i] == symbol) {
                sum++;
            }
        }
        i = 1;
        if (sum == WINS || tempField[i][i] == symbol && tempField[i + 1][i - 1] == symbol && tempField[i - 1][i + 1] == symbol) {
            return true;
        }
        return false;

    }

}