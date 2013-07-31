package com.game.xo.players;


import java.util.Random;

public class Computer extends Player {
    private static final String name = "Computer";
    private int pcX;
    private int pcY;

    public Computer() {
        super(name);
    }

    public void primaryStage(char[][] tempField, int playerX, int playerY) {
        Random rn = new Random();
        do{
            pcX = rn.nextInt(tempField.length);
            System.out.println(pcX + " " + playerX);
            pcY = rn.nextInt(tempField.length);
            System.out.println(pcY + " " + playerY);


        } while(pcX == playerX && pcY == playerY);
    }
}
