package com.game.xo.players;

public class Player {
    private String name;
    private boolean flagStep; // zero if didn`t step, else one
    private int playerStep; //how many steps do player
    private char playerSymbol;
    private boolean youWin = false;


    public Player(String name) {
        this.name = name;
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

    public void setPlayerStep(int step) {
          playerStep = step;
    }
    public int getPlayerStep() {
        return playerStep;
    }

    public void setYouWin(boolean win) {
        youWin = win;
    }

    public boolean getYouWin() {
        return youWin;
    }

}
