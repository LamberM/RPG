package org.LamberM.utils;

import java.util.List;

public class MenuChooser {

    public MenuChooser(InputReader inputReader, List<String> menu) {
        if (menu.isEmpty()) {
            throw new IllegalArgumentException("Menu can't be empty");
        }
        this.inputReader = inputReader;
        this.minValueChoice = 1;
        this.maxValueChoice = menu.size();
        this.menu = menu;
        this.outWriter = new SystemOutWriter();
    }
    private SystemOutWriter outWriter;
    private final InputReader inputReader;
    private final int minValueChoice;
    private final int maxValueChoice;
    private final List<String> menu;

    private void showMenu() {
        for (String line : this.menu) {
            outWriter.setText(line);
            outWriter.show();
        }
    }

    private boolean requiredValue(int userChoice) {
        return userChoice >= minValueChoice && userChoice <= maxValueChoice;
    }

    public int userPick() {
        int tries = 0;
        showMenu();
        int userChoice = Integer.parseInt(inputReader.read());
        while (!requiredValue(userChoice)) {
            tries++;
            outWriter.setText("Tries: " + tries);
            outWriter.show();
            if (tries > 5) {
                throw new IllegalArgumentException("You made mistakes too much");
            }
            outWriter.setText("You entered the wrong number. Try again");
            outWriter.show();
            userChoice = Integer.parseInt(inputReader.read());
        }
        return userChoice;
    }
}