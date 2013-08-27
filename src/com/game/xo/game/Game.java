package com.game.xo.game;

import com.game.xo.choice.ChoiceSymbol;
import com.game.xo.display.IDisplay;
import com.game.xo.field.IField;
import com.game.xo.input.InputDataNumber;
import com.game.xo.input.InputDataString;
import com.game.xo.players.Computer;
import com.game.xo.players.Human;
import com.game.xo.players.Player;

public class Game implements IGame {
    private Player player1;
    private Player player2;
    private InputDataString inputDataString;
    private InputDataNumber inputDataNumber;
    private IDisplay display;
    private IField field;
    private boolean endOfGame;
    private int globalSteps = 0;
    private final int MAX_CELLS = 9;

    public Game(Player player1, Player player2, IDisplay display, IField field) {
        this.player1 = player1;
        this.player2 = player2;
        this.display = display;
        this.field = field;
        inputDataString = new InputDataString();
        inputDataNumber = new InputDataNumber();
        endOfGame = false;
    }

    public void startGame() {
        ChoiceSymbol choiceSymbol = new ChoiceSymbol();

        do {
            display.displayMessage("Game start.\n");
            choiceSymbol.chooseSymbol(player1, player2);
            do{
            display.displayMessage(player1.getName() + " your symbol : " + player1.getPlayerSymbol() + "\n");
            display.displayMessage(player2.getName() + " your symbol : " + player2.getPlayerSymbol() + "\n");
            display.displayMessage("\n");
            field.displayField();
            gameMoves(player1, player2);
            }while (globalSteps < MAX_CELLS);
        } while (!endOfGame);

        if(globalSteps >= MAX_CELLS){
           display.displayMessage("Standoff");
        }


    }

    private void gameMoves(Player player1, Player player2) {
        insertToField(player1);
        insertToField(player2);
        //add check if game end and player want to start new game
        //endOfGame = true;
    }

    private void insertToField(Player player) {
        do {
            display.displayMessage("Player " + player.getName() + ". Your symbol  " + player.getPlayerSymbol() + ".");
            player.getCoordinates(display);
        } while (!field.setGameField(player, display));
        globalSteps++;
        player.setPlayerSteps(globalSteps);
        field.displayField();
    }


}