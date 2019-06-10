//Gian Esteves Period 8 APCS Final Project

import java.util.Scanner;

public class Connect4 {

    public static int rows = 6;
    public static int columns = 7;

    public static int turn = 1;

    public static int[][] board = new int[rows][columns];

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to connect 4");
        System.out.println("");

        //Print empty board
        printBoard();
        System.out.println("");

        System.out.println("1 goes first");

        while (true) {
            setPiece(turn);

            turn++;

            System.out.println("Turn #" + turn);
            printBoard();

            if (checkWin(1) == true || checkWin(2) == true) {
                System.out.println("Game over!");

                if (turn % 2 == 1) {
                    System.out.println("2 Wins!");
                } else {
                    System.out.println("1 Wins!");
                }

                break;
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j]);
                System.out.print("   ");
            }
            System.out.println();
        }

    }

    public static void setPiece(int color) {
        System.out.println("Please choose a column, 1 - 7");

        int choice = input.nextInt();

        choice = choice - 1;

        while (choice >= 7 || choice < 0) {
            System.out.println("Out of bounds");
            System.out.println("Select another column");

            choice = input.nextInt();
            choice = choice - 1;
        }

        //Check 6 down
        for (int i = 5; i > -1; i--) {
            if (board[i][choice] == 0) {

                //Alternate pieces by turn
                if (turn % 2 == 1) {
                    board[i][choice] = 1;
                    break;
                } else {
                    board[i][choice] = 2;
                    break;
                }
            }

            //Check if column is overflowing
            if (board[0][choice] != 0) {
                System.out.println("uh oh");
                System.out.println("Select another column");

                choice = input.nextInt();
                choice = choice - 1;

                i++;
            }
        }
    }

    public static boolean checkWin(int player) {
        if (checkHori(player) == true || checkVert(player) == true) {
            return true;
        }
        return false;
    }

    public static boolean checkHori(int player) {
        for (int j = 0; j < columns - 3; j++) {
            for (int i = 0; i < rows; i++) {
                if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player && board[i][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkVert(int player) {
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player && board[i + 3][j] == player) {
                    return true;
                }
            }
        }
        return false;
    }
}
