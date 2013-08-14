package com.game.xo.input;


public class InputDataNumber extends InputDataString {
    public int getNumber() {
        int temp = -1;
        try {
            temp = Integer.parseInt(getData());
        } catch (Exception e) {

        }
        return temp;
    }

}
