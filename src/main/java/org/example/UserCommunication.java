package org.example;

import java.util.Random;
import java.util.Scanner;

public class UserCommunication {

    private String player1;
    private String player2;
    private char player1Sign;
    private char player2Sign;
    private char computerSign;
    private String computer = "Computer";

    Scanner scan = new Scanner(System.in);


    public String choosePlayer1Name() {
        System.out.println("Player 1, please choose your name");
        Player player = new Player(scan.next());
        player1 = player.getName();
        return "You chose name: " + player;
    }

    public String choosePlayer2Name() {
        System.out.println("Player 2, please choose your name");
        Player player = new Player(scan.next());
        player2 = player.getName();
        return "You chose name: " + player;
    }

    public String chooseComputerName() {
        int decision;
        System.out.println("Do you want to choose computer name? If yes hit 1, if not hit 2. If not we will keep it as `Computer`");
        decision = scan.nextInt();
        if (decision == 1) {
            System.out.println("Please enter computer name");
            computer = scan.nextLine();
            return "Computer name you have chosen is: " + computer;
        } else {
            return "Computer stays as: " + computer;
        }
    }

//    public void chooseYourSymbolPVP() { // need to figure out how to assign x and o to a player
//        int decision;
//        System.out.println(player1 + " choose your symbol. If you want 'X' click 1, if you want 'O' click 2");
//        decision = scan.nextInt();
//        if (decision == 1) {
//            player1Sign = 'X';
//            gm.addPlayerToSign();
//            System.out.println(player1 + " chose 'X'. " + player2 + " will be playing 'O'.");
//        } else {
//            player2Sign = 'O';
//            gm.addPlayerToSign();
//            System.out.println(player1 + " chose 'O'. " + player2 + " will be playing 'X'.");;
//        }
//    }

//    public void chooseYourSymbolPVE() { // need to figure out how to assign x and o to a player
//        int decision;
//        System.out.println(player1 + " choose your symbol. If you want 'X' click 1, if you want 'O' click 2");
//        decision = scan.nextInt();
//        if (decision == 1) {
//
//            System.out.println(player1 + " chose 'X'. " + computer + " will be playing 'O'");
//        } else {
//            System.out.println(player1 + " chose 'O'. " + computer + " will be playing 'X'");
//        }
//    }

//    public void whoStartsFirstPVP() { //need to figure out how to assign who starts first
//        int decision;
//        int order;
//        int number;
//        System.out.println("Would you like to choose who starts first, or should we choose randomly?"
//                            + "Please type 1 if you want to choose, or 2 if you want to choose randomly");
//        decision = scan.nextInt();
//        if (decision == 1) {
//            System.out.println("Who is starting first? Type 1 for player1 or 2 for player2");
//            order = scan.nextInt();
//            if (order == 1) {
//                GameLogic.setCurrentPlayer(Players.whoMoves.PLAYER1);
//                System.out.println(player1 + " will be starting first");
//            } else {
//                GameLogic.setCurrentPlayer(Players.whoMoves.PLAYER2);
//                System.out.println(player2 + " will be starting first");
//            }
//        } else {
//            Random random = new Random();
//            number = random.nextInt(2);
//            if (number == 0) {
//                GameLogic.setCurrentPlayer(Players.whoMoves.PLAYER1);
//                System.out.println(player1 + " will be starting first");
//            } else {
//                GameLogic.setCurrentPlayer(Players.whoMoves.PLAYER2);
//                System.out.println(player2 + " will be starting first");
//            }
//        }
//    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getComputer() {
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
