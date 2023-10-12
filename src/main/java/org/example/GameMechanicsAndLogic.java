package org.example;

import java.util.Random;

import static org.example.CheckForWin.*;

public class GameMechanicsAndLogic {

    private char[][] board;
    private int boardSize;
    private Player currentPlayer;
    private Player firstPlayer;
    private Player secondPlayer;
    private int firstPlayerPoints;
    private int secondPlayerPoints;
    private char currentSign = 'X';
    private int rounds;
    private boolean playWithComputer;

    public void createBoard() {
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
        for (int cols = 0; cols < boardSize; cols++)
            System.out.print("  " + cols + " ");
        System.out.println();
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

    public void changePlayer() {
        if (currentSign == 'X' && currentPlayer == firstPlayer) {
            currentSign = 'O';
            currentPlayer = secondPlayer;
        } else if (currentSign == 'X' && currentPlayer == secondPlayer) {
            currentSign = 'O';
            currentPlayer = firstPlayer;
        } else if (currentSign == 'O' && currentPlayer == firstPlayer) {
            currentSign = 'X';
            currentPlayer = secondPlayer;
        } else if (currentSign == 'O' && currentPlayer == secondPlayer) {
            currentSign = 'X';
            currentPlayer = firstPlayer;
        }
    }

    public boolean isRoundFinished() {
        if (isItWin(board, currentSign)) {
            displayBoard();
            System.out.println(currentPlayer + " wins this round!");
            countingPoints();
            return true;
        }
        if (CheckForWin.isItDraw(board)) {
            displayBoard();
            System.out.println("Game finished as draw");
            return true;
        }
        return false;
    }

    public void countingPoints() {
        if (currentPlayer == firstPlayer) {
            firstPlayerPoints++;
        } else {
            secondPlayerPoints++;
        }
    }

    public boolean isGameFinished() {
        if (firstPlayerPoints >= rounds) {
            System.out.println(firstPlayer + " wins the game!");
            return true;
        } else if (secondPlayerPoints >= rounds) {
            System.out.println(secondPlayer + " wins wins the game!");
            return true;
        }
        return false;
    }

    public boolean isItWin(char[][] board, char sign) {
        int winningLength = (boardSize < 6) ? boardSize : 5;
        for (int k = 0; k < boardSize; k++) {
            char winner = checkRowWinner(board, k, winningLength);
            winner = (winner == ' ') ? checkColumnWinner(board, k, winningLength): winner;
            if (winner == 'X' || winner == 'O') {
                return true;
            }
        }
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < boardSize; col++) {
                char winner = checkDiagonalWin(board, row, col, winningLength);
                if (winner == 'X' || winner == 'O') {
                    return true;
                }
            }
        }
        return false;
    }

    public void makeMove() {
        int row = 0, col = 0;
        boolean moveIsOk = false;
        try {
             while (!moveIsOk) {
                System.out.println("Player " + currentPlayer + ", enter row number (0-2) and column number (0-2) seperated by space. Your sign is: " + currentSign);
                Coords coords = UserDialogs.getTheCoords(boardSize);
                row = coords.getRow();
                col = coords.getCol();
                moveIsOk = board[row][col] == ' ';
             }
        } catch (Exception e) {
            System.out.println("Field is taken, try again!");
        }
        board[row][col] = currentSign;
    }

    public void computerMove() {
        Random random = new Random();
        int row, col;
        while (true) {
            row = random.nextInt(boardSize);
            col = random.nextInt(boardSize);
            if (board[row][col] == ' ') {
                board[row][col] = currentSign;
                break;
            }
        }
    }

    public void displayScores() {
        System.out.println("Number of points needed to win: " + rounds);
        System.out.println(firstPlayer + " has " + firstPlayerPoints + " points");
        System.out.println(secondPlayer + " has " + secondPlayerPoints + " points");
        System.out.println();
    }

    public void playGame() {
        playWithComputer = UserDialogs.getIfPlayWithComputer();
        firstPlayer = new Player(UserDialogs.getPlayerName("1"));
        if (!playWithComputer) {
            secondPlayer = new Player(UserDialogs.getPlayerName("2"));
        } else {
            secondPlayer = new Player("Computer");
        }
        boardSize = UserDialogs.chooseSizeOfBoard();
        rounds = UserDialogs.getNumberOfRounds();
        firstPlayerPoints = 0;
        secondPlayerPoints = 0;
        while (!isGameFinished()) {
            if (UserDialogs.whoStartsFirst() == 1)
                currentPlayer = firstPlayer;
            else
                currentPlayer = secondPlayer;
            if (!playWithComputer)
                gameWithPlayer();
            if (playWithComputer && currentPlayer == firstPlayer)
                gameWithComputerWhenPlayerStarts();
            if (playWithComputer && currentPlayer == secondPlayer)
                gameWithComputerWhenComputerStarts();
        }
    }

    public void gameWithPlayer() {
        createBoard();
        initializeBoard();
        while (true) {
            displayBoard();
            makeMove();
            if (isRoundFinished()) {
                displayScores();
                break;
            }
            changePlayer();
        }
    }

    public void gameWithComputerWhenPlayerStarts() {
        createBoard();
        initializeBoard();
        while (true) {
            displayBoard();
            makeMove();
            if (isRoundFinished()) {
                displayScores();
                break;
            }
            changePlayer();
            computerMove();
            if (isRoundFinished()) {
                displayScores();
                break;
            }
            changePlayer();
        }
    }

    public void gameWithComputerWhenComputerStarts() {
        createBoard();
        initializeBoard();
        while (true) {
            computerMove();
            if (isRoundFinished()) {
                displayScores();
                break;
            }
            changePlayer();
            displayBoard();
            makeMove();
            if (isRoundFinished()) {
                displayScores();
                break;
            }
            changePlayer();
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public int getFirstPlayerPoints() {
        return firstPlayerPoints;
    }

    public int getSecondPlayerPoints() {
        return secondPlayerPoints;
    }

    public char getCurrentSign() {
        return currentSign;
    }

    public int getRounds() {
        return rounds;
    }
}
