package com.game.xo.players;


import com.game.xo.display.IDisplay;
import com.game.xo.field.ConsoleField;
import java.util.Random;

public class Computer extends Player {
    private static final String NAME = "Computer";
    private final int STATE1 = 1;
    private final int STATE3 = 3;

    public Computer() {
        super(NAME);
    }

    @Override
    public void getCoordinates(IDisplay display, Player player) {
//        super.getCoordinates(display);    //To change body of overridden methods use File | Settings | File Templates.
    display.displayMessage("Generate coordinates\n");
        generateCoordinates(player.getAxisX(), player.getAxisY());

    }

    private void generateCoordinates(int axisX, int axisY) {
        int size = 2;
        Random randomGenerator = new Random();

        do {
            setAxisY(randomGenerator.nextInt(size));
            System.out.println("\n" + getAxisX() + " " + axisX);
            setAxisY(randomGenerator.nextInt(size));
            System.out.println(getAxisY() + " " + axisY);
        } while (getAxisX() == axisX && getAxisY() == axisY);
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

    public boolean createMove(Player player1, Player player2) {

        switch (player1.getPlayerSteps()) {
            case STATE1:
                return setFirstSymbol(player1.getAxisX(), player1.getAxisY());

            case STATE3:
                return checkIrregularState();

            default:
//                return checkRegularState(field, size);
                break;
        }

      return true;
    }

    private boolean setFirstSymbol(int playerX, int playerY) {
        int size = 2;
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
                setFirstSymbol(i, 2);
            }
        }
        return true;
    }
}
