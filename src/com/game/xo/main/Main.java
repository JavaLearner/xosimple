package com.game.xo.main;

import com.game.xo.common.CreateGame;
//import com.game.xo.players.Player;
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

       /* Player newPlayer = new Player();

        System.out.print("Enter your name: ");
        String namePlayer = myScanner.nextLine();

        newPlayer.setName(namePlayer);
        System.out.println(newPlayer.getName());
         */


        int intSymbol;
        while (endOfGameFlag) {
            myGame = new CreateGame();
            char chosenSymbol = myGame.getDefaultSymbol();

            System.out.println("Game start.");
            myGame.viewArray();
            System.out.print("Choose your symbol 1 - x or 0 - 0: ");
            intSymbol = myScanner.nextInt();
            switch (intSymbol) {
                case 0:
                    chosenSymbol = myGame.getSymbol0();
                    break;
                case 1:
                    chosenSymbol = myGame.getSymbolX();
                    break;
                default:
                    System.out.println("Invalid option!!!");
                    flagError = false;
                    break;
            }

            while (myGame.getGlobalStepCount() < maxCells && flagError) {
                myGame.gameStep(chosenSymbol, flagError);
                if (myGame.getGlobalStepCount() < maxCells) {
                    myGame.viewArray();
                }
            }
            myGame.viewArray();

            //System.out.println("continueGame: " + continueGame);

            System.out.print("\nYou want to start new game? y/n: ");
            continueGame = myScanner2.nextLine();

            //System.out.println("continueGame: " + continueGame);
            //add checking if entered not y/Y
           if (continueGame.charAt(0) == 'n' || continueGame.charAt(0) == 'N') {
                endOfGameFlag = false;
            }
            flagError = true;

        }
        System.out.println("\nEnd of game...");
    }


}
