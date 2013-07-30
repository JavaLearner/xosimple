package com.game.xo.common;

import com.game.xo.players.Human;
import com.game.xo.players.Player;

import java.util.Scanner;

public class StartGame {
    public static final int MAX_STEPS = 9;
    Scanner scanner = new Scanner(System.in);

    public void startGame() {
        boolean flagError = true;//false when no errors
        boolean endOfGameFlag = true;//false if exit from game
        String continueGame, namePlayer, chooseSymbol;
        GameProcess newGame;

        while (endOfGameFlag) {
            newGame = new GameProcess();

            viewMessage("Game start.\n");

            viewMessage("Enter first name: ");
            namePlayer = scanner.nextLine();
            Player firstPlayer = new Human(namePlayer);

            viewMessage("Enter second name: ");
            namePlayer = scanner.nextLine();
            Player secondPlayer = new Human(namePlayer);

            newGame.displayGameField();

            do {
                viewMessage(firstPlayer.getName() + "\nChoose your symbol x or 0 : ");
                chooseSymbol = scanner.nextLine();
                switch (chooseSymbol.charAt(0)) {
                    case '0':
                        setSymbol(firstPlayer, secondPlayer,flagError, newGame);
                        break;
                    case 'x':
                        setSymbol(secondPlayer, firstPlayer,flagError, newGame);
                        break;
                    default:
                        viewMessage("Invalid option!!! Try again.");
                        flagError = false;
                        break;
                }
            } while (!flagError);
            while (!firstPlayer.getYouWin() && !secondPlayer.getYouWin() && secondPlayer.getPlayerSteps() < MAX_STEPS) {
                viewMessage(firstPlayer.getName() + " your turn. Your symbol: " + firstPlayer.getPlayerSymbol());
                newGame.gameMovies(firstPlayer, flagError);
                newGame.displayGameField();
                if (firstPlayer.getYouWin()) {
                    break;
                }
                if (firstPlayer.getPlayerSteps() >= MAX_STEPS) {
                    viewMessage("\nStandoff");
                    break;
                }
                viewMessage(secondPlayer.getName() + " your turn. Your symbol: " + secondPlayer.getPlayerSymbol());
                newGame.gameMovies(secondPlayer, flagError);
                newGame.displayGameField();

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
    private static void setSymbol(Player player1, Player player2, boolean flagError, GameProcess newGame) {
        player1.setPlayerSymbol(newGame.SYMBOL_0);
        player2.setPlayerSymbol(newGame.SYMBOL_X);
        flagError = true;

    }

    private static void viewMessage(String string) {
        System.out.println(string);
    }


}
