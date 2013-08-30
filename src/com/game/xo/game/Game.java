package com.game.xo.game;

import com.game.xo.choice.ChoiceSymbol;
import com.game.xo.display.IDisplay;
import com.game.xo.field.IField;
import com.game.xo.input.InputDataNumber;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Player;

public class Game implements IGame {
    private Player player1;
    private Player player2;
    private InputDataString inputDataString;
    private InputDataNumber inputDataNumber;
    private IDisplay display;
    private IField field;
    private boolean endOfGame;
    private int globalSteps = 0;
    private final int MAX_CELLS = 9;
    private final int MAX_INDEX = 3;
    private int findWinner;


    public Game(Player player1, Player player2, IDisplay display, IField field) {
        this.player1 = player1;
        this.player2 = player2;
        this.display = display;
        this.field = field;
        inputDataString = new InputDataString();
        inputDataNumber = new InputDataNumber();
        endOfGame = false;
    }

    public void startGame() {
        ChoiceSymbol choiceSymbol = new ChoiceSymbol();
        do {
            display.displayMessage("Game start.\n");
            choiceSymbol.chooseSymbol(player1, player2);
            do {
                display.displayMessage(player1.getName() + " your symbol : " + player1.getPlayerSymbol() + "\n");
                display.displayMessage(player2.getName() + " your symbol : " + player2.getPlayerSymbol() + "\n");
                display.displayMessage("\n");
                field.displayField();
                gameMoves(player1, player2);
                display.displayMessage("globalSteps " + globalSteps + "\n");

            } while (globalSteps < MAX_CELLS);
            if (globalSteps >= MAX_CELLS && !player1.getYouWin() && !player2.getYouWin()) {
                display.displayMessage("Standoff\n");
                getChoice();
            }
        } while (!endOfGame);


    }

    private void gameMoves(Player player1, Player player2) {
        insertToField(player1);
        if (globalSteps < MAX_CELLS) {
            insertToField(player2);
        }

    }

    private void insertToField(Player player) {
        do {
            display.displayMessage("Player " + player.getName() + ". Your symbol  " + player.getPlayerSymbol() + ".");
            player.getCoordinates(display);
        } while (!field.setGameField(player, display));
        checkWin(player);
        globalSteps++;
        player.setPlayerSteps(globalSteps);
        display.displayMessage("Player Steps " + player.getPlayerSteps());
        display.displayMessage("\n");
        field.displayField();
    }

    private char checkChoice(char inputChar) {
        if (inputChar == 'y' || inputChar == 'Y') {
            return 'y';
        }
        if (inputChar == 'n' || inputChar == 'N') {
            return 'n';
        }
        return 'e';

    }

    private void getChoice() {
        boolean flagContinue;

        do {
            display.displayMessage("You want to start new game? y/n : ");
            String choiceString = inputDataString.getData();
            switch (checkChoice(choiceString.charAt(0))) {
                case 'y':
                    field.clearField();
                    globalSteps = 0;
                    flagContinue = true;
                    break;
                case 'n':
                    endOfGame = true;
                    flagContinue = true;
                    break;
                default:
                    display.displayMessage("Invalid option.\n");
                    flagContinue = false;
                    break;
            }
        } while (!flagContinue);
    }

    private void checkWin(Player player) {
        if (searchWinner(player.getPlayerSymbol())) {
            display.displayMessage("\n" + player.getName() + " you win!!!\n");
            field.displayField();
            player.setYouWin(true);
            getChoice();
        }
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
        for (int i = 0; i < MAX_INDEX; i++) {
            findWinner = rowWinnerSub(i, symbol);
            if (findWinner == MAX_INDEX) {
                return true;
            }
        }
        return false;
    }

    private int rowWinnerSub(int axisX, char symbol) {
        int sum = 0;
        for (int j = 0; j < MAX_INDEX; j++) {
            if (field.getGameField(axisX, j) == symbol) {
                sum++;
            }
        }
        return sum;
    }

    /*search winner in columns*/
    private boolean columnWinner(char symbol) {
        for (int i = 0; i < MAX_INDEX; i++) {
            findWinner = columnWinnerSub(i, symbol);
            if (findWinner == MAX_INDEX) {
                return true;
            }
        }
        return false;
    }

    private int columnWinnerSub(int axisY, char symbol) {
        int sum = 0;
        for (int j = 0; j < MAX_INDEX; j++) {
            if (field.getGameField(j, axisY) == symbol) {
                sum++;
            }
        }
        return sum;
    }

    /*search winner in diagonals*/
    private boolean diagonalWinner(char symbol) {
        int i, sum = 0;
        for (i = 0; i < MAX_INDEX; i++) {
            if (field.getGameField(i, i) == symbol) {
                sum++;
            }
        }
        i = 1;
        if (sum == MAX_INDEX || field.getGameField(i, i) == symbol &&
                field.getGameField(i + 1, i - 1) == symbol && field.getGameField(i - 1, i + 1) == symbol) {
            return true;
        }
        return false;

    }
}