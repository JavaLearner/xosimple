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
        final int maxCells = 9;
        boolean flagError = true;//false when no errors

        Scanner myScanner = new Scanner(System.in);

        CreateGame myGame = new CreateGame();

       /* Player newPlayer = new Player();

        System.out.print("Enter your name: ");
        String namePlayer = myScanner.nextLine();

        newPlayer.setName(namePlayer);
        System.out.println(newPlayer.getName());
         */

        char chosenSymbol = myGame.getDefaultSymbol();
        int intSymbol;

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
                break;
        }


        while (myGame.getGlobalStepCount() < maxCells) {
            myGame.gameStep(chosenSymbol, flagError);
            if (myGame.getGlobalStepCount() < maxCells) {
                myGame.viewArray();
            }
        }
        System.out.println("End of game...");
    }

}
