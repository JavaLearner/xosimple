package com.game.xo.common;

import com.game.xo.players.*;

import java.util.Scanner;

public class Game {
    public static final int MAX_STEPS = 9;
    private final char HUMAN_PLAY = 'h';
    private final char COMPUTER_PLAY = 'c';



    private Scanner scanner = new Scanner(System.in);

    public void Game() {
        boolean flagError = true;//false when no errors
        boolean endOfGameFlag = true;//false if exit from game
        String continueGame;
        String namePlayer;
        String chosenSymbol;
        String tempOption;
        char chosenOption;
        Field field;

        while (endOfGameFlag) {
            field = new Field();

            viewMessage("Field start.\n");

            viewMessage("Enter first name: ");
            namePlayer = scanner.nextLine();
            Player firstPlayer = new Human(namePlayer);
            Player secondPlayer = new Player();

            //check creation second player????????
            do {
                viewMessage("You play with human or computer? h/c: ");
                tempOption = scanner.nextLine();
                chosenOption = whatChosen(tempOption);
                switch (chosenOption) {
                    case COMPUTER_PLAY:
                        secondPlayer = new Computer();
                        break;
                    case HUMAN_PLAY:
                        viewMessage("Enter second name: ");
                        namePlayer = scanner.nextLine();
                        secondPlayer = new Human(namePlayer);
                        break;
                    default:
                        viewMessage("Invalid option!!! Try again.");
                        flagError = false;
                        break;
                }
            } while (!flagError);
            field.displayField();

            do {
                viewMessage(firstPlayer.getName() + "\nChoose your symbol x or 0 : ");
                chosenSymbol = scanner.nextLine();
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
                field.gameMovies(firstPlayer, flagError);
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
            continueGame = scanner.nextLine();

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
        scanner.nextLine();
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
}