package com.game.xo.main;


import com.game.xo.display.ConsoleDisplay;
import com.game.xo.field.ConsoleField;
import com.game.xo.players.Player;
import com.game.xo.choice.Choice;
import  com.game.xo.game.Game;
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
      public ConsoleDisplay consoleDisplay = new ConsoleDisplay();



    public static void main(String[] args) {
        Choice choice = new Choice();
        Game game = new Game(choice.choosePlayer(), choice.choosePlayer());
        game.startGame();

    }


}



