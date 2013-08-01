package com.game.xo.players;


import com.game.xo.game.Field;

import java.util.Random;

public class Computer extends Player {
    private static final String name = "Computer";
    private int pcX;
    private int pcY;

    public Computer() {
        super(name);
    }

    public int getPcX() {
        return pcX;
    }

    public int getPcY() {
        return pcY;
    }

    public boolean setFirstSymbol(int size, int playerX, int playerY) {
        Random rn = new Random();

        do {
            pcX = rn.nextInt(size);
            System.out.println(pcX + " " + playerX);
            pcY = rn.nextInt(size);
            System.out.println(pcY + " " + playerY);


        } while (pcX == playerX && pcY == playerY);
        return true;
    }
}
