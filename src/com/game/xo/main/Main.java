package com.game.xo.main;


import com.game.xo.game.Game;

/**
 * Created with IntelliJ IDEA.
 * User: JL Junior
 * Date: 7/9/13
 * Time: 10:30 PM
 * simple game "Tic Tac Toe" for console
 */
public class Main {

       public static void main(String[] args) {
           Game game = new Game();
           game.createGame();

           /*char[][] temp = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
           int x = 1;
           int y = 0;

           ArtificialIntelligence artificialIntelligence = new ArtificialIntelligence();
           artificialIntelligence.primaryStage(temp, x, y);
           */
       }
}



