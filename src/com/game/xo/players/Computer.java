package com.game.xo.players;


import java.util.Random;

public class Computer extends Player {
    private static final String NAME = "Computer";
//    private int pcX;
//    private int pcY;

    public Computer() {
        super(NAME);
    }

//    public int getPcX() {
//        return pcX;
//    }
//
//    public int getPcY() {
//        return pcY;
//    }

    public boolean setFirstSymbol(int size, int playerX, int playerY) {
        Random randomGenerator = new Random();

        do {
              setAxisY(randomGenerator.nextInt(size));
            System.out.println(getAxisX() + " " + playerX);
            setAxisY(randomGenerator.nextInt(size));
            System.out.println(getAxisY() + " " + playerY);
        } while (getAxisX() == playerX && getAxisY() == playerY);
        return true;
    }
}
