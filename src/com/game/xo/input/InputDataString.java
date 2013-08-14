package com.game.xo.input;

import java.util.Scanner;

public class InputDataString implements IInputData {
    private Scanner in = new Scanner(System.in);

    public String getData() {
        String message = null;
        try {
            message = in.nextLine();
            return message;
        } catch (Exception e) {
            message = e.getMessage();
        } finally {
            return message;

        }
    }
}
