package com.game.xo.common;


public class LogicAlgorithm {

    public LogicAlgorithm(char[][] newArray, int cells) {

        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < cells; j++) {
                if (newArray[i][j] == ' ') {
                    System.out.print("(" + i + "," + j + ") ");
                } else {
                    System.out.print("  " + newArray[i][j] + "   ");

                }
            }
            System.out.println();
        }
        System.out.println("class LogicAlgorithm ");

    }


}
