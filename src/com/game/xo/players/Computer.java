package com.game.xo.players;


import com.game.xo.field.ConsoleField;

import java.util.Random;

public class Computer extends Player {
    private static final String NAME = "Computer";
    private final int STATE1 = 1;
    private final int STATE3 = 3;

    public Computer() {
        super(NAME);
    }

//    @Override
//    public void setPlayerSymbol(char symbol) {
//        Random randomGenerator = new Random();
//        switch (randomGenerator.nextInt(2)){
//            case 0:
//                super.setPlayerSymbol('0');
//                break;
//            case 1:
//                super.setPlayerSymbol('x');
//                break;
//            default:
//                break;
//        }
//
//    }

    public boolean createMove(ConsoleField field, Player player, int size, int globalStepCount) {

        switch (globalStepCount) {
            case STATE1:
                return setFirstSymbol(size, player.getAxisX(), player.getAxisY());

            case STATE3:
                return checkIrregularState();

            default:
                return checkRegularState(field, size);
        }


    }

    private boolean setFirstSymbol(int size, int playerX, int playerY) {
        Random randomGenerator = new Random();

        do {
            setAxisY(randomGenerator.nextInt(size));
            System.out.println("\n" + getAxisX() + " " + playerX);
            setAxisY(randomGenerator.nextInt(size));
            System.out.println(getAxisY() + " " + playerY);
        } while (getAxisX() == playerX && getAxisY() == playerY);
        return true;
    }


    private boolean checkIrregularState() {
        return true;
    }

    private boolean checkRegularState(ConsoleField field, int size) {
        //|| checkColumn() || checkDiagonal()
        if (checkRow(field, size)) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkRow(ConsoleField field, int size) {
        for (int i = 0; i < size; i++) {
            if (field.getGameField(i, i) != this.getPlayerSymbol() && field.getGameField(i, i + 1) != this.getPlayerSymbol()) {
                if (field.getGameField(i, i) != this.getPlayerSymbol()) {
                    setAxisX(i);
                    setAxisY(2);
                }

                //field.setGameField(i, 2, this.getPlayerSymbol());
                return true;
            } else {
                setFirstSymbol(size, i, 2);
            }
        }
        return true;
    }
}
