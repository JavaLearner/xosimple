package com.game.xo.main;

import com.game.xo.common.CreateGame;
import com.game.xo.players.Human;
import com.game.xo.players.Player;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * User: JavaLearner
 * Date: 7/9/13
 * Time: 10:30 PM
 * simple game "Tic Tac Toe" for console
 */
public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Scanner myScanner2 = new Scanner(System.in);

        final int maxCells = 9;
        boolean flagError = true;//false when no errors
        boolean endOfGameFlag = true;//false if exit from game

        String continueGame;
        CreateGame myGame;

        int intSymbol;
        while (endOfGameFlag) {
            myGame = new CreateGame();
            char chosenSymbol = myGame.getDefaultSymbol();

            System.out.println("Game start.");
            Player firstPlayer = new Human();
            Player secondPlayer = new Human();

            System.out.print("Enter first name: ");
            String namePlayer = myScanner.nextLine();
            firstPlayer.setName(namePlayer);

            System.out.print("Enter second name: ");
            namePlayer = myScanner.nextLine();
            secondPlayer.setName(namePlayer);
           // System.out.println(firstPlayer.getName());

            myGame.viewArray();
            System.out.print(firstPlayer.getName() + "Choose your symbol 1 - x or 0 - 0: ");
            intSymbol = myScanner.nextInt();
            switch (intSymbol) {
                case 0:
                    chosenSymbol = myGame.getSymbol0();
                    firstPlayer.setPlayerSymbol(chosenSymbol);
                    secondPlayer.setPlayerSymbol(myGame.getSymbolX());
                    break;
                case 1:
                    chosenSymbol = myGame.getSymbolX();
                    firstPlayer.setPlayerSymbol(chosenSymbol);
                    secondPlayer.setPlayerSymbol(myGame.getSymbol0());
                    break;
                default:
                    System.out.println("Invalid option!!!");
                    flagError = false;
                    break;
            }
            while (!firstPlayer.getYouWin() || !secondPlayer.getYouWin()) {
                myGame.gameStep(firstPlayer.getPlayerSymbol(), secondPlayer.getPlayerSymbol(), flagError);
                if (myGame.getGlobalStepCount() < maxCells) {
                    myGame.viewArray();
                }
            }
            myGame.viewArray();


            System.out.print("\nYou want to start new game? y/n: ");
            continueGame = myScanner2.nextLine();

            //add checking if entered not y/Y
           if (continueGame.charAt(0) == 'n' || continueGame.charAt(0) == 'N') {
                endOfGameFlag = false;
            }
            flagError = true;

        }
        System.out.println("\nEnd of game...");
    }


}
