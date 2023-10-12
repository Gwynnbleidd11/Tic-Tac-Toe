package org.example;

import java.util.Scanner;

public class UserDialogs {

    public static boolean getIfPlayWithComputer() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Play with computer? (Y/N)");
            String ans = scan.nextLine();
            if (ans.toUpperCase().equals("Y"))
                return true;
            if (ans.toUpperCase().equals("N"))
                return false;
            System.out.println("Wrong selection, try again.");
        }
    }

    public static String getPlayerName(String number) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter player " + number + " name: ");
            String ans = scan.nextLine();
            return ans;
        }
    }

    public static String getPlayer2Name(String number) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter player " + number + " name: ");
            String ans = scan.nextLine();
            return ans;
        }
    }

    public static int whoStartsFirst() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Which player should start? (1/2)");
            String ans = scan.nextLine();
            if (ans.equals("1"))
                return 1;
            if (ans.equals("2"))
                return 2;
            System.out.println("Wrong answer, try again");
        }
    }

    public static int getNumberOfRounds() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("How many rounds would you like to play? Max 10");
            String ans = scan.nextLine();
            try {
                int n = Integer.parseInt(ans);
                if (n >= 1 && n <= 10) {
                    return n;
                }
                System.out.println("Wrong number, try again");
            } catch (Exception e) {
                System.out.println("Wrong number, try again");
            }
        }
    }

    public static int chooseSizeOfBoard() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose board dimensions. Min 3, max 10. ");
            String ans = scan.nextLine();
            try {
                int n = Integer.parseInt(ans);
                if (n >= 1 && n <= 10) {
                    return n;
                }
                System.out.println("Wrong number, try again");
            } catch (Exception e) {
                System.out.println("Wrong number, try again");
            }
        }
    }

    public static Coords getTheCoords(int boardSize) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String coord = scanner.nextLine();
            String[] splitted = coord.split(" ");
            try {
                int row = Integer.parseInt(splitted[0]);
                int col = Integer.parseInt(splitted[1]);
                if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
                    throw new Exception();
                } else {
                    return new Coords(row, col);
                }
            } catch (Exception e) {
                System.out.println("Wrong coords, try again");
                System.out.println();
            }
        }
    }
}
