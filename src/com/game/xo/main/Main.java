package com.game.xo.main;

import com.game.xo.common.CreateGame;
import com.game.xo.players.Human;
import com.game.xo.players.Player;

import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * User: JL Junior
 * Date: 7/9/13
 * Time: 10:30 PM
 * simple game "Tic Tac Toe" for console
 */
public class Main {
    public static void main(String[] args) {
        final int maxSteps = 9;

        Scanner myScanner = new Scanner(System.in);
        Scanner myScanner2 = new Scanner(System.in);

        //final int maxCells = 9;
        boolean flagError = true;//false when no errors
        boolean endOfGameFlag = true;//false if exit from game

        String continueGame;
        CreateGame myGame;

        int intSymbol;
        while (endOfGameFlag) {
            myGame = new CreateGame();

            System.out.println("Game start.");

            System.out.print("Enter first name: ");
            String namePlayer = myScanner.nextLine();
            Player firstPlayer = new Human(namePlayer);

            System.out.print("Enter second name: ");
            namePlayer = myScanner.nextLine();
            Player secondPlayer = new Human(namePlayer);

            myGame.viewArray();
            System.out.print(firstPlayer.getName() + "\nChoose your symbol 1 - x or 0 - 0: ");
            intSymbol = myScanner.nextInt();
            switch (intSymbol) {
                case 0:
                    firstPlayer.setPlayerSymbol(myGame.getSymbol0());
                    secondPlayer.setPlayerSymbol(myGame.getSymbolX());

                    break;
                case 1:
                    firstPlayer.setPlayerSymbol(myGame.getSymbolX());
                    secondPlayer.setPlayerSymbol(myGame.getSymbol0());

                    break;
                default:
                    System.out.println("Invalid option!!!");
                    flagError = false;
                    break;
            }
            while (!firstPlayer.getYouWin() && !secondPlayer.getYouWin() && secondPlayer.getPlayerSteps() < maxSteps) {
                System.out.println(firstPlayer.getName() + " your turn. Your symbol: " + firstPlayer.getPlayerSymbol());
                myGame.gameStep(firstPlayer, flagError);
                myGame.viewArray();
                if (firstPlayer.getYouWin()) {
                    break;
                }
                System.out.println(secondPlayer.getName() + " your turn. Your symbol: " + secondPlayer.getPlayerSymbol());
                myGame.gameStep(secondPlayer, flagError);
                myGame.viewArray();
            }
            if(secondPlayer.getPlayerSteps() >= maxSteps) {
                System.out.println("\nStandoff\n");
            }
            System.out.print("\nYou want to start new game? y/n: ");
            continueGame = myScanner2.nextLine();

            //add checking if entered not y/Y
            if (continueGame.charAt(0) == 'n' || continueGame.charAt(0) == 'N') {
                endOfGameFlag = false;
            }
            flagError = true;

        }
        System.out.println("\nEnd of game...");
        continueGame = myScanner2.nextLine();

    }


}
