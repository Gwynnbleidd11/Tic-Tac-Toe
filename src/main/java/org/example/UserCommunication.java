package org.example;

import java.util.Random;
import java.util.Scanner;

public class UserCommunication {

    private Player player1;
    private Player player2;
    private Player computer;
    private char player1Sign;
    private char player2Sign;
    private char computerSign;

    public Player choosePlayer1Name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, please choose your name");
        Player player = new Player(scanner.next());
        player1 = player;
        System.out.println("You chose name: " + player1);
        return player;
    }

    public Player choosePlayer2Name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 2, please choose your name");
        Player player = new Player(scanner.next());
        player2 = player;
        System.out.println("You chose name: " + player2);
        return player;
    }

    public Player chooseComputerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to choose computer name? If yes hit 1, if not hit 2. If not we will keep it as `Computer`");
        int decision = scanner.nextInt();
        if (decision == 1) {
            System.out.println("Please enter computer name");
            Player comp = new Player(scanner.next());
            computer = comp;
            System.out.println("Computer name you have chosen is: " + computer);
            return computer;
        } else {
            Player comp = new Player("Computer");
            computer = comp;
            System.out.println("Computer stays as: " + computer);
            return computer;
        }
    }

    public void chooseYourSymbolPVP() {
        Scanner scanner = new Scanner(System.in);
        int decision;
        System.out.println(player1 + " choose your symbol. If you want 'X' click 1, if you want 'O' click 2");
        decision = scanner.nextInt();
        if (decision == 1) {
            player1Sign = 'X';
            player2Sign = 'O';
            System.out.println(player1 + " chose 'X'. " + player2 + " will be playing 'O'");
        } else {
            player1Sign = 'O';
            player2Sign = 'X';
            System.out.println(player1 + " chose 'O'. " + player2 + " will be playing 'X'");
        }
    }

    public void chooseYourSymbolPVE() {
        Scanner scanner = new Scanner(System.in);
        int decision;
        System.out.println(player1 + " choose your symbol. If you want 'X' click 1, if you want 'O' click 2");
        decision = scanner.nextInt();
        if (decision == 1) {
            player1Sign = 'X';
            computerSign = 'O';
            System.out.println(player1 + " chose 'X'. " + computer + " will be playing 'O'");
        } else {
            player1Sign = 'O';
            computerSign = 'X';
            System.out.println(player1 + " chose 'O'. " + computer + " will be playing 'X'");
        }
    }

    public void whoStartsFirstPVP() {
        GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
        Scanner scanner = new Scanner(System.in);
        int decision;
        int order;
        int number;
        System.out.println("Would you like to choose who starts first, or should we choose randomly?"
                + " Please type 1 if you want to choose, or 2 if you want to choose randomly");
        decision = scanner.nextInt();
        if (decision == 1) {
            System.out.println("Who is starting first? Type 1 for " + player1 + " or 2 for "  + player2);
            order = scanner.nextInt();
            if (order == 1) {
                gmal.setCurrentPlayer(player1);
                gmal.setCurrentSign(player1Sign);
                gmal.setSecondPlayer(player2);
                System.out.println(player1 + " will be starting first");
            } else {
                gmal.setCurrentPlayer(player2);
                gmal.setCurrentSign(player2Sign);
                gmal.setSecondPlayer(player1);
                System.out.println(player2 + " will be starting first");
            }
        } else {
            Random random = new Random();
            number = random.nextInt(2);
            if (number == 0) {
                gmal.setCurrentPlayer(player1);
                gmal.setCurrentSign(player1Sign);
                gmal.setSecondPlayer(player2);
                System.out.println(player1 + " will be starting first");
            } else {
                gmal.setCurrentPlayer(player2);
                gmal.setCurrentSign(player2Sign);
                gmal.setSecondPlayer(player1);
                System.out.println(player2 + " will be starting first");
            }
        }
    }

    public void whoStartsFirstPVE(GameMechanicsAndLogic gmal) {
        Scanner scanner = new Scanner(System.in);
        int decision;
        int order;
        int number;
        System.out.println("Would you like to choose who starts first, or should we choose randomly?"
                            + " Please type 1 if you want to choose, or 2 if you want to choose randomly");
        decision = scanner.nextInt();
        if (decision == 1) {
            System.out.println("Who is starting first? Type 1 for " + player1 + " or 2 for "  + computer);
            order = scanner.nextInt();
            if (order == 1) {
                gmal.setCurrentPlayer(player1);
                gmal.setCurrentSign(player1Sign);
                gmal.setSecondPlayer(computer);
                System.out.println(player1 + " will be starting first");
            } else {
                gmal.setCurrentPlayer(computer);
                gmal.setCurrentSign(computerSign);
                gmal.setSecondPlayer(player1);
                System.out.println(computer + " will be starting first");
            }
        } else {
            Random random = new Random();
            number = random.nextInt(2);
            if (number == 0) {
                gmal.setCurrentPlayer(player1);
                gmal.setCurrentSign(player1Sign);
                gmal.setSecondPlayer(computer);
                System.out.println(player1 + " will be starting first");
            } else {
                gmal.setCurrentPlayer(computer);
                gmal.setCurrentSign(computerSign);
                gmal.setSecondPlayer(player1);
                System.out.println(computer + " will be starting first");
            }
        }
    }
    // dlaczego settery nie przesyłają wartości zmiennych z tej klasy do koasy kolejnej? setCurrentPlayer, setCurrentSign

    public static Coords getTheCoords() {
        Scanner scanner = new Scanner(System.in);
        GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
        while (true) {
            System.out.println("Player " + gmal.getCurrentPlayer() + ", enter row number (0-2) and column number (0-2) seperated by space. Your sign is: " + gmal.getCurrentSign());
            String coord = scanner.nextLine();
            String[] splitted = coord.split(" ");
            try {
                int row = Integer.parseInt(splitted[0]);
                int col = Integer.parseInt(splitted[1]);
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    throw new Exception();
                } else {
                    return new Coords(row, col);
                }
            } catch (Exception e) {
                System.out.println("Wrong coords or field is already taken, try again");
            }
        }
    }

    public static Coords getTheCoords10x10() {
        Scanner scanner = new Scanner(System.in);
        GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
        while (true) {
            System.out.println("Player " + gmal.getCurrentPlayer() + ", enter row number (0-9) and column number (0-9) seperated by space. Your sign is: " + gmal.getCurrentSign());
            String coord = scanner.nextLine();
            String[] splitted = coord.split(" ");
            try {
                int row = Integer.parseInt(splitted[0]);
                int col = Integer.parseInt(splitted[1]);
                if (row < 0 || row > 9 || col < 0 || col > 9) {
                    throw new Exception();
                } else {
                    return new Coords(row, col);
                }
            } catch (Exception e) {
                System.out.println("Wrong coords or field is already taken, try again");
            }
        }
    }

    public void gameStart() {
        Scanner scanner = new Scanner(System.in);
        GameMechanicsAndLogic regularGame = new GameMechanicsAndLogic();
        GameMechanicsAndLogic10x10 bigBoardGame = new GameMechanicsAndLogic10x10();
        System.out.println("If you would like to play with other player, type 1 and if you would like to play against computer, type 2.");
        int decision = scanner.nextInt();
        try {
            if (decision == 1) {
                playerVersusPlayer();
            } else if (decision == 2) {
                playerVersusComputer(regularGame);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Please choose 1 for player vs player game or 2 for player vs computer game");
        }
        System.out.println("Please choose 1 for regular game, or 2 for game on 10x10 board");
        int boardDecision = scanner.nextInt();
        try {
            if (decision == 1 && boardDecision == 1) {
                regularGame.regularGameWithPlayer();
            } else if (decision == 2 && boardDecision == 1) {
                regularGame.regularGameWithComputer();
            } else if (decision == 1 && boardDecision == 2) {
                bigBoardGame.bigBoardGameWithPlayer();
            } else if (decision == 2 && boardDecision == 2) {
                bigBoardGame.bigBoardGameWithComputer();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Please choose 1 for regular game, or 2 for game on 10x10 board");
        }
        scanner.close();
    }

    public void playerVersusPlayer() {
        choosePlayer1Name();
        choosePlayer2Name();
        chooseYourSymbolPVP();
        whoStartsFirstPVP();
    }

    public void playerVersusComputer(GameMechanicsAndLogic gmal) {
        choosePlayer1Name();
        chooseComputerName();
        chooseYourSymbolPVE();
        whoStartsFirstPVE(gmal);
    }



    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getComputer() {
        return computer;
    }

    public char getPlayer1Sign() {
        return player1Sign;
    }

    public char getPlayer2Sign() {
        return player2Sign;
    }

    public char getComputerSign() {
        return computerSign;
    }


}
