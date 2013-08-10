package com.game.xo.players;

public class Player {
    private String name;
    private int gameSteps;
    private char playerSymbol;
    private boolean youWin = false;


    public Player(String name) {
        this.name = name;
        gameSteps = 0;

    }

    //getters and setters


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

}
