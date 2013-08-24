package com.game.xo.players;

import com.game.xo.display.IDisplay;
import com.game.xo.input.InputDataNumber;
import com.game.xo.input.InputDataString;

public class Player {
    private String name;
    private int gameSteps;
    private char playerSymbol;
    private boolean youWin = false;
    private int axisX;
    private int axisY;
    //    private InputDataString inputDataString;
    private InputDataNumber inputDataNumber;


    public Player(String name) {
        this.name = name;
        gameSteps = 0;
        inputDataNumber = new InputDataNumber();

    }

    //getters and setters


    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public int getAxisX() {
        return axisX;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    public int getAxisY() {
        return axisY;
    }

    public String getName() {
        return name;
    }

    public void setPlayerSymbol(char symbol) {
        playerSymbol = symbol;
    }


    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSteps(int step) {
        gameSteps = step;
    }

    public int getPlayerSteps() {
        return gameSteps;
    }

    public void setYouWin(boolean win) {
        youWin = win;
    }

    public boolean getYouWin() {
        return youWin;
    }

    public void getCoordinates(IDisplay display) {
        display.displayMessage("\nPlease enter your coordinate (x,): ");
        axisX = inputDataNumber.getNumber();
        display.displayMessage("\nPlease enter your coordinate (,y): ");
        axisY = inputDataNumber.getNumber();

    }

}
