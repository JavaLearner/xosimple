package com.game.xo.main;


import com.game.xo.game.ConsoleField;
import com.game.xo.game.Game;
import com.game.xo.players.KindPlayer;
import com.game.xo.players.Player;

/**
 * Created with IntelliJ IDEA.
 * User: JL Junior
 * Date: 7/9/13
 * Time: 10:30 PM
 * simple game "Tic Tac Toe" for console
 */
public class Main {

    public static void main(String[] args) {
        KindPlayer kindPlayer = new KindPlayer();
        ConsoleField consoleField = new ConsoleField();

        Player firstPlayer = kindPlayer.chooseKind();
        Player secondPlayer = kindPlayer.chooseKind();


        Game game = new Game(firstPlayer, secondPlayer, consoleField);
        game.createGame();


    }




}



