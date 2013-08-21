package com.game.xo.game;

import com.game.xo.choice.ChoiceSymbol;
import com.game.xo.display.IDisplay;
import com.game.xo.field.IField;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Player;

public class Game implements IGame {
    private Player player1;
    private Player player2;
    private InputDataString inputDataString = new InputDataString();
    private IDisplay display;
    private IField field;
    private boolean endOfGame;

    public Game(Player player1, Player player2, IDisplay display, IField field) {
        this.player1 = player1;
        this.player2 = player2;
        this.display = display;
        this.field = field;
    }

    public void startGame() {
        ChoiceSymbol choiceSymbol = new ChoiceSymbol();

//        do{
        display.displayMessage("Game start.\n");
        choiceSymbol.chooseSymbol(player1, player2);
        display.displayMessage(player1.getName() + " your symbol : " + player1.getPlayerSymbol() + "\n");
        display.displayMessage(player2.getName() + " your symbol : " + player2.getPlayerSymbol() + "\n");
        display.displayMessage("\n");
        field.displayField();
//            gameMoves(player1, player2);
//        }while(endOfGame);


    }

//    private void gameMoves(Player player1, Player player2) {
//
//    }

}