package org.example;

import java.util.Scanner;

public class GameMechanicsAndLogic {

    private char[][] board = new char [3][3];
    private String currentPlayer;
    private char currentSign = 'X';
    UserCommunication uc = new UserCommunication();

    public void initializeGameBoard() {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public void changePlayerPVP() {
        if (currentSign == 'X') {
            currentSign = 'O';
        } else {
            currentSign = 'X';
        }
    }

    public void changePlayerPVE() {
        if (currentSign == 'X') {
            currentSign = 'O';
        } else {
            currentSign = 'X';
        }
    }


    public boolean isGameFinished() {
        if (isItWin('X')) {
            displayBoard();
            System.out.println(uc.getPlayer1() + " wins!");
            return true;
        }

        if (isItWin('O')) {
            displayBoard();
            System.out.println(uc.getPlayer2() + " wins!");
            return true;
        }

//        if (isItWin(uc.getComputerSign())) {
//            displayBoard();
//            System.out.println(uc.getComputer() + " wins!");
//            return true;
//        }

        if (isItDraw()) {
            displayBoard();
            System.out.println("Game finished as draw");
            return true;
        }
        return false;
    }

    private boolean isItDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ');
                return false;
            }
        }
        return true;
    }

    private boolean isItWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public void makeMove() {
        Scanner sc = new Scanner(System.in);
        int row, col;
        do {
            System.out.println("Player " + currentSign + ", enter row number (0-2) and column number (0-2) seperated by space");
            row = sc.nextInt();
            col = sc.nextInt();
        } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');
        board[row][col] = currentSign;
    }

//    public static void setCurrentPlayer(Enum currentPlayer) {
//        GameLogic.currentPlayer = currentPlayer;
//    }
//
//    public static void setSign(Enum sign) {
//        GameLogic.sign = sign;
//    }
//
//    public static Enum getCurrentPlayer() {
//        return currentPlayer;
//    }
//
//    public static Enum getSign() {
//        return sign;
//    }
}
