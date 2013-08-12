package com.game.xo.game;

import com.game.xo.display.ConsoleDisplay;
import com.game.xo.input.InputDataString;
import com.game.xo.players.KindPlayer;
import com.game.xo.players.Player;


public class Game {
    public final int MAX_STEPS = 9;
    private final char EMPTY_CELL = ' ';
    private final char SYMBOL_X = 'x';
    private final char SYMBOL_0 = '0';
    private int globalStepCount = 0;
    private static int axisX;
    private static int axisY;
    private int findWinner;
    private final int SIZE = 3;
    private final int MAX_INDEX = 2;
    private final int MIN_INDEX = 0;



    private ConsoleField field;
    private Player firstPlayer;
    private Player secondPlayer;

    private InputDataString inputData = new InputDataString();
    private ConsoleDisplay consoleDisplay = new ConsoleDisplay();
    private KindPlayer kindPlayer = new KindPlayer();

    public Game(Player firstPlayer, Player secondPlayer, ConsoleField field) {
            this.firstPlayer = firstPlayer;
            this.secondPlayer = secondPlayer;
            this.field = field;
    }

    public void createGame() {
        boolean flagError;//false when no errors
        boolean endOfGameFlag = true;//false if exit from game
        String continueGame;
        String chosenSymbol;

        while (endOfGameFlag) {
            do {
            consoleDisplay.displayMessage("Game start.\n");


            field.displayField();



                consoleDisplay.displayMessage(firstPlayer.getName() + "\nChoose your symbol x or 0 : ");
                chosenSymbol = inputData.getData();

                //add - check if chosen x/X or 0.
                switch (chosenSymbol.charAt(0)) {
                    case SYMBOL_0:
                        setSymbol(firstPlayer, secondPlayer);
                        flagError = true;
                        break;
                    case SYMBOL_X:
                        setSymbol(secondPlayer, firstPlayer);
                        flagError = true;
                        break;
                    default:
                        consoleDisplay.displayMessage("Invalid option!!! Try again.");
                        flagError = false;
                        break;
                }
            } while (!flagError);
            while (!firstPlayer.getYouWin() && !secondPlayer.getYouWin() && firstPlayer.getPlayerSteps() < MAX_STEPS) {
                consoleDisplay.displayMessage(firstPlayer.getName() + " your turn. Your symbol: " + firstPlayer.getPlayerSymbol());
                gameMoves(firstPlayer, flagError);

                field.displayField();
                if (firstPlayer.getYouWin()) {
                    break;
                }
                if (firstPlayer.getPlayerSteps() >= MAX_STEPS) {
                    consoleDisplay.displayMessage("\nStandoff\n");
                    break;
                }
                consoleDisplay.displayMessage(secondPlayer.getName() + " your turn. Your symbol: " + secondPlayer.getPlayerSymbol());
                gameMoves(secondPlayer, flagError);
                field.displayField();

            }

            consoleDisplay.displayMessage("Start the new game? y/n: ");
            continueGame = inputData.getData();

            flagError = false;
            while (!flagError) {
                if (continueGame.charAt(0) == 'y' || continueGame.charAt(0) == 'Y') {
                    endOfGameFlag = true;
                    globalStepCount = 0;
                } else {
                    if (continueGame.charAt(0) == 'n' || continueGame.charAt(0) == 'N') {
                        endOfGameFlag = false;
                    } else {
                        consoleDisplay.displayMessage("Invalid option!!! Try again.");

                    }
                }
                flagError = true;
            }

        }

        consoleDisplay.displayMessage("\nEnd of game...");
//        in.nextLine();
    }



    public void gameMoves(Player player, boolean flagError) {

        while (flagError && !player.getYouWin()) {

            if(kindPlayer.getPlayerMove(player,axisX,axisY, SIZE)){
               axisX = player.getAxisX();
               axisY = player.getAxisY();
            flagError = checkWin(player, flagError);
            }

        }


    }

    private boolean checkWin(Player player, boolean flagError) {

        if (!searchWinner(player.getPlayerSymbol()) && checkCoordinates()) {
            if (field.getGameField(axisX, axisY) == EMPTY_CELL) {
                field.setGameField(axisX, axisY, player.getPlayerSymbol());
                flagError = update(flagError, player);
                if (searchWinner(player.getPlayerSymbol())) {
                    consoleDisplay.displayMessage("\n" + player.getName() + " you win!!!\n");
                    player.setYouWin(true);
                    flagError = false;
                }
            }
        } else {
            consoleDisplay.displayMessage("Your coordinates invalid.\nPlease enter correct coordinates.\n");
            field.displayField();
            flagError = true;
        }

        return flagError;
    }

    private boolean checkCoordinates() {
        if (axisX >= MIN_INDEX && axisX <= MAX_INDEX && axisY >= MIN_INDEX && axisY <= MAX_INDEX) {
            return true;
        } else {
            return false;
        }
    }

    private boolean update(boolean flagError, Player player) {
        if (flagError) {
            globalStepCount++;
            player.setPlayerSteps(globalStepCount);
        }
        flagError = false;
        return flagError;

    }

    private void setSymbol(Player player1, Player player2) {
        player1.setPlayerSymbol(SYMBOL_0);
        player2.setPlayerSymbol(SYMBOL_X);

    }



    public boolean searchWinner(char symbol) {
        if (checkRowWinner(symbol) || checkColumnWinner(symbol) || checkDiagonalWinner(symbol)) {
            return true;
        } else {
            return false;
        }
    }

    /*search winner in rows*/
    private boolean checkRowWinner(char symbol) {

        for (int i = 0; i < SIZE; i++) {
            findWinner = checkRowWinnerSub(i, symbol);
            if (findWinner == SIZE) {
                return true;
            }
        }
        return false;
    }

    private int checkRowWinnerSub(int axisX, char symbol) {
        int sum = 0;
        for (int j = 0; j < SIZE; j++) {
            if (field.getGameField(axisX, j) == symbol) {
                sum++;
            }
        }
        return sum;
    }

    /*search winner in columns*/
    private boolean checkColumnWinner(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            findWinner = checkColumnWinnerSub(i, symbol);
            if (findWinner == SIZE) {
                return true;
            }
        }
        return false;
    }

    private int checkColumnWinnerSub(int axisY, char symbol) {
        int sum = 0;
        for (int j = 0; j < SIZE; j++) {
            if (field.getGameField(j, axisY) == symbol) {
                sum++;
            }
        }
        return sum;
    }

    /*search winner in diagonals*/
    private boolean checkDiagonalWinner(char symbol) {
        int i, sum = 0;
        for (i = 0; i < SIZE; i++) {
            if (field.getGameField(i, i) == symbol) {
                sum++;
            }
        }
        i = 1;
        if (sum == SIZE || field.getGameField(i, i) == symbol && field.getGameField(i + 1, i - 1) == symbol && field.getGameField(i - 1, i + 1) == symbol) {
            return true;
        }
        return false;

    }

}