package org.example;

import java.util.Random;

public class GameMechanicsAndLogic {

    private char[][] board = new char [3][3];
    private Player currentPlayer;
    private Player secondPlayer;
    private char currentSign;

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        int rows = 0;
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(rows++ + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println(" ------------");
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

    public boolean isGameFinished() {
        UserCommunication uc = new UserCommunication();
        if (isItWin(board, 'X')) {
            displayBoard();
            System.out.println(uc.getPlayer1() + " wins!");
            return true;
        }

        if (isItWin(board, 'O')) {
            displayBoard();
            System.out.println(uc.getPlayer2() + " wins!");
            return true;
        }

//        if (isItWin()) {
//            displayBoard();
//            System.out.println(uc.getComputer() + " wins!");
//            return true;
//        }

        if (isItDraw(board)) {
            displayBoard();
            System.out.println("Game finished as draw");
            return true;
        }
        return false;
    }

    public boolean isItDraw(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public boolean isItWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public void makeMove() {
        int row = 0, col = 0;
        boolean moveIsOk = false;
        while (!moveIsOk) {
            Coords coords = UserCommunication.getTheCoords();
            row = coords.getRow();
            col = coords.getCol();
            moveIsOk = board[row][col] == ' ';
        }
        board[row][col] = currentSign;
    }

    public void computerMove() {
        Random random = new Random();
        int row, col;
        while (true) {
            row = random.nextInt(3);
            col = random.nextInt(3);
            if (board[row][col] == ' ') {
                board[row][col] = currentSign;
                break;
            }
        }
    }

    public void regularGameWithPlayer() {
        initializeBoard();
        while (true) {
            displayBoard();
            makeMove();
            if (isGameFinished()) {
                break;
            }
            changePlayer();
        }
    }

    public void regularGameWithComputer() {
        initializeBoard();
        while (true) {
            displayBoard();
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
        return board;
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
