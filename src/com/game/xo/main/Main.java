package com.game.xo.main;

import com.game.xo.common.CreateGame;
import com.game.xo.players.Player;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: JavaLearner
 * Date: 7/9/13
 * Time: 10:30 PM
 * simple game xo for console
 */
public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        CreateGame myGame = new CreateGame();
        myGame.viewArray();

        Player newPlayer = new Player();
        System.out.print("Enter your name: ");
        String namePlayer = myScanner.nextLine();

        newPlayer.setName(namePlayer);
        System.out.println(newPlayer.getName());
    }

}
