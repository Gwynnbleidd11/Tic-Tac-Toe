package org.example;

import java.util.Random;

public class GameMechanicsAndLogic10x10 {

    private char[][] bigBoard = new char[10][10];
    private Player currentPlayer;
    private Player secondPlayer;
    private Player temporaryPlayer;
    private char currentSign = 'X';

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
        if (currentSign == 'X') {
            currentSign = 'O';
            temporaryPlayer = currentPlayer;
            currentPlayer = secondPlayer;
            secondPlayer = temporaryPlayer;
        } else {
            currentSign = 'X';
            temporaryPlayer = currentPlayer;
            currentPlayer = secondPlayer;
            secondPlayer = temporaryPlayer;
        }
    }

    public void makeMove() {
        int row, col;
        Coords coords = UserCommunication.getTheCoords10x10();
        row = coords.getRow();
        col = coords.getCol();
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
        if (isItWin(currentSign)) {
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

    public boolean isItWin(char player) {
        for (int i = 0; i < 10; i++) {
            if (bigBoard[i][0] == player && bigBoard[i][1] == player && bigBoard[i][2] == player) {
                return true;
            }
            if (bigBoard[0][i] == player && bigBoard[1][i] == player && bigBoard[2][i] == player) {
                return true;
            }
        }
        if (bigBoard[0][0] == player && bigBoard[1][1] == player && bigBoard[2][2] == player) {
            return true;
        }
        if (bigBoard[0][2] == player && bigBoard[1][1] == player && bigBoard[2][0] == player) {
            return true;
        }
        return false;
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

    public void bigBoardGameWithComputer() {
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