package com.game.xo.input;


public class InputDataNumber extends InputDataString {
    public int getNumber() {
        return Integer.parseInt(getData());
    }

}
