package org.example;

import java.util.Random;

public class GameMechanicsAndLogic10x10 {

    private char[][] bigBoard = new char[10][10];
    private Player currentPlayer;
    private Player secondPlayer;
    private char currentSign;

    public void initializeBigBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                bigBoard[i][j] = ' ';
            }
        }
    }

    public void displayBigBoard() {
        int rows = 0;
        System.out.println("  0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < 10; i++) {
            System.out.print(rows++ + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(bigBoard[i][j]);
                if (j < 9) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 9) {
                System.out.println(" ---------------------------------------");
            }
        }
    }

    public void changePlayer() {
        Player temporaryPlayer;
        if (currentSign == 'X') {
            currentSign = 'O';
        } else {
            currentSign = 'X';
        }
        temporaryPlayer = currentPlayer;
        currentPlayer = secondPlayer;
        secondPlayer = temporaryPlayer;
    }

    public void makeMove() {
        UserCommunication uc = new UserCommunication();
        int row = 0, col = 0;
        boolean moveIsOk = false;
        try {
            while (!moveIsOk) {
                System.out.println("Player " + currentPlayer + ", enter row number (0-9) and column number (0-9) seperated by space. Your sign is: " + currentSign);
                Coords coords = uc.getTheCoords10x10();
                row = coords.getRow();
                col = coords.getCol();
                moveIsOk = bigBoard[row][col] == ' ';
            }
        } catch (Exception e) {
            System.out.println("Field is taken, try again!");
        }
        bigBoard[row][col] = currentSign;
    }

    public void computerMove() {
        Random random = new Random();
        int row, col;
        while (true) {
            row = random.nextInt(10);
            col = random.nextInt(10);
            if (bigBoard[row][col] == ' ') {
                bigBoard[row][col] = currentSign;
                break;
            }
        }
    }

    public boolean isGameFinished() {
        if (isItWin()) {
            displayBigBoard();
            System.out.println(currentPlayer + " wins!");
            return true;
        }
        if (isItDraw()) {
            displayBigBoard();
            System.out.println("Game finished as draw");
            return true;
        }
        return false;
    }

    private boolean isItDraw() {
        for (int i = 0; i < bigBoard.length; i++) {
            for (int j = 0; j < bigBoard[i].length; j++) {
                if (bigBoard[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public boolean isItWin() {
        int winningLength = 5;
        for (int col = 0; col < bigBoard.length; col++) {
            char winner = checkColumnWinner(col, winningLength);
            if (winner == currentSign) {
                return true;
            }
        }
        for (int row = 0; row < bigBoard.length; row++) {
            char winner = checkRowWinner(row, winningLength);
            if (winner == currentSign) {
                return true;
            }
        }
        return false;
    }

    private char checkRowWinner(int row, int winningLength) {
        char lastItem = ' ';
        int counter = 0;
        for (int col = 0; row < bigBoard.length; row++) {
            if (bigBoard[col][row] == lastItem && lastItem != ' ') {
                counter++;
            } else {
                counter = 1;
                lastItem = bigBoard[col][row];
            }
            if (counter >= winningLength)
                return lastItem;
        }
        return ' ';
    }

    private char checkColumnWinner(int col, int winningLength) {
        char lastItem = ' ';
        int counter = 0;
        for (int row = 0; row < bigBoard.length; row++) {
            if (bigBoard[col][row] == lastItem && lastItem != ' ') {
                counter++;
            } else {
                counter = 1;
                lastItem = bigBoard[col][row];
            }
            if (counter >= winningLength)
                return lastItem;
        }
        return ' ';
    }

    public void bigBoardGameWithPlayer() {
        initializeBigBoard();
        while (true) {
            displayBigBoard();
            makeMove();
            if (isGameFinished()) {
                break;
            }
            changePlayer();
        }
    }

    public void bigBoardGameWithComputerWhenPlayerStarts() {
        initializeBigBoard();
        while (true) {
            displayBigBoard();
            makeMove();
            if (isGameFinished()) {
                break;
            }
            changePlayer();
            computerMove();
            if (isGameFinished()) {
                break;
            }
            changePlayer();
        }
    }

    public void bigBoardGameWithComputerWhenComputerStarts() {
        initializeBigBoard();
        while (true) {
            computerMove();
            if (isGameFinished()) {
                break;
            }
            changePlayer();
            displayBigBoard();
            makeMove();
            if (isGameFinished()) {
                break;
            }
            changePlayer();
        }
    }

    public char[][] getBoard() {
        return bigBoard;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public char getCurrentSign() {
        return currentSign;
    }

    public void setCurrentSign(char currentSign) {
        this.currentSign = currentSign;
    }
}