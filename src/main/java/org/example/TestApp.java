package org.example;


public class TestApp {
    public static void main(String[] args) {

        GameMechanicsAndLogic start = new GameMechanicsAndLogic();


        start.initializeGameBoard();
        while (true) {
            start.displayBoard();
            start.makeMove();
            if (start.isGameFinished()) {
                break;
            }
            start.changePlayerPVP();
        }
    }
}