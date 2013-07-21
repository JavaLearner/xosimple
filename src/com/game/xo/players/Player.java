package com.game.xo.players;

public class Player {
    private String name;
    private boolean flagStep; // zero if didn`t step, else one
    private int playerStep; //how many steps do player
    private char playerSymbol;


    //getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
