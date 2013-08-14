package com.game.xo.main;


import com.game.xo.field.ConsoleField;
import com.game.xo.game.Game;
import com.game.xo.players.Human;
import com.game.xo.players.Player;

/**
 * Created with IntelliJ IDEA.
 * User: JL Junior
 * Date: 7/9/13
 * Time: 10:30 PM
 * simple game "Tic Tac Toe" for console
 */
public class Main {
      public Player firstPlayer;
      public Player secondPlayer;
      public ConsoleField field;

    public static void main(String[] args) {
        chosePlayers();
        Game game = new Game(firstPlayer, secondPlayer, field);
        game.startGame();

    }

     public static void chosePlayers() {

     }
}



