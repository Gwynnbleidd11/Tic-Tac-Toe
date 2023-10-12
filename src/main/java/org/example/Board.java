package org.example;

public class Board {

    private char[][] board;
    private int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new char[boardSize][boardSize];
    }

    public void initializeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        int rows = 0;
        System.out.println("  0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(rows++ + " ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j]);
                if (j < boardSize - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < boardSize - 1) {
                System.out.println(" " + "----".repeat(boardSize));
            }
        }
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public char setCell(int row, int col, char currentSign) {
        return board[row][col] = currentSign;
    }

    public int getBoardSize() {
        return boardSize;
    }



}