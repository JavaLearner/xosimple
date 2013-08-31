package com.game.xo.players;


import com.game.xo.display.IDisplay;
import com.game.xo.field.ConsoleField;
import com.game.xo.field.IField;

import java.util.Random;

public class Computer extends Player {
    private static final String NAME = "Computer";
    private final int STATE1 = 1;
    private final int STATE3 = 3;
//    private final int MAX_INDEX =

    public Computer() {
        super(NAME);
    }
    public Computer(int number) {
        super(NAME + " " + number);
    }

    @Override
    public void getCoordinates(IDisplay display) {
        //display.displayMessage("Generate coordinates\n");
        generateCoordinates();

    }

    @Override
    public String getInfo() {
        return "Play " + getName() + ".";
    }

    private void generateCoordinates() {
        int size = 3;
        Random randomGenerator = new Random();
        setAxisX(randomGenerator.nextInt(size));
        setAxisY(randomGenerator.nextInt(size));

    }


    public boolean createMove(Player player1, Player player2) {

        switch (player1.getPlayerSteps()) {
            case STATE1:
//                return setFirstSymbol(player1.getAxisX(), player1.getAxisY());
                return true;
            case STATE3:
//                return checkIrregularState();
                return true;

            default:
//                return checkRegularState(field, size);
                break;
        }

        return true;
    }

//    private boolean setFirstSymbol(int playerX, int playerY) {
//        int size = 3;
//        Random randomGenerator = new Random();
//
//        do {
//            setAxisY(randomGenerator.nextInt(size));
//            System.out.println("\n" + getAxisX() + " " + playerX);
//            setAxisY(randomGenerator.nextInt(size));
//            System.out.println(getAxisY() + " " + playerY);
//        } while (getAxisX() == playerX && getAxisY() == playerY);
//        return true;
//    }


//    private boolean checkIrregularState() {
//        return true;
//    }

//    private boolean checkRegularState(IField field, int size) {
//        //|| checkColumn() || checkDiagonal()
//        if (checkRow(field, size)) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }
//
//    private boolean checkRow(IField field, int size) {
//        for (int i = 0; i < size; i++) {
//            if (field.getGameField(this) != this.getPlayerSymbol() && field.getGameField(this) != this.getPlayerSymbol()) {
//                if (field.getGameField(this) != this.getPlayerSymbol()) {
//                    setAxisX(i);
//                    setAxisY(2);
//                }
//
//                //field.setGameField(i, 2, this.getPlayerSymbol());
//                return true;
//            } else {
//                setFirstSymbol(i, 2);
//            }
//        }
//        return true;
//    }
}
