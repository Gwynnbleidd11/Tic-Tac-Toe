package org.example;

public class CheckForWin {

    public static char checkRowWinner(char[][] board, int row, int winningLength) {
        char lastItem = ' ';
        int counter = 0;
        for (int col = 0; col < board.length; col++) {
            if (board[row][col] == lastItem && lastItem != ' ') {
                counter++;
            } else {
                counter = 1;
                lastItem = board[row][col];
            }
            if (counter >= winningLength)
                return lastItem;
        }
        return ' ';
    }

    public static char checkColumnWinner(char[][] board, int col, int winningLength) {
        char lastItem = ' ';
        int counter = 0;
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == lastItem && lastItem != ' ') {
                counter++;
            } else {
                counter = 1;
                lastItem = board[row][col];
            }
            if (counter >= winningLength)
                return lastItem;
        }
        return ' ';
    }

    public static char checkDiagonalWin(char[][] board, int startRow, int startCol, int winningLength) {
        char lastItem = ' ';
        int counter = 0;
        for (int i = 0; i < winningLength; i++) {
            int row = startRow + i;
            int col = startCol + i;
            if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
                break;
            }
            if (board[row][col] == lastItem && lastItem != ' ') {
                counter++;
            } else {
                counter = 1;
                lastItem = board[row][col];
            }

            if (counter >= winningLength) {
                return lastItem;
            }
        }
        lastItem = ' ';
        counter = 0;
        for (int i = 0; i < winningLength; i++) {
            int row = startRow + i;
            int col = startCol - i;
            if (row < 0 || row >= board.length|| col < 0 || col >= board[row].length) {
                break;
            }
            if (board[row][col] == lastItem && lastItem != ' ') {
                counter++;
            } else {
                counter = 1;
                lastItem = board[row][col];
            }
            if (counter >= winningLength) {
                return lastItem;
            }
        }
        return ' ';
    }

    public static boolean isItDraw(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
