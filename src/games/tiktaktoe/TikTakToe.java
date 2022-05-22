package games.tiktaktoe;

import java.util.Scanner;

public class TikTakToe {

    public static void main(String[] args) {

        String[][] board = new String[3][3];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
               board[i][j] = "_";
            }
        }

        printBoard(board);
        System.out.println();

        boolean isXTurn = true;
        String variable = "";

        Scanner scanner = new Scanner(System.in);
        while(hasGameEnded(board).equals("not ended")) {
            if(isXTurn) {
                variable = "X";
            } else {
                variable = "0";
            }
            System.out.println();
            System.out.println("Insert " + variable + " in line and column (0-2)");
            int line = scanner.nextInt();
            int column = scanner.nextInt();
            if(board[line][column].equals("X") || board[line][column].equals("0")) {
                System.out.println("Place is already taken");
                printBoard(board);
            } else {
                board[line][column] = variable;
                printBoard(board);
                if(variable.equals("X")) {
                    isXTurn = false;
                } else {
                    isXTurn = true;
                }
            }
            String status = hasGameEnded(board);
            if(status.equals(variable + " won")) {
                System.out.println();
                System.out.println(variable + " won");
                return;
            } else if(status.equals("draw")) {
                System.out.println();
                System.out.println("draw");
                return;
            }
        }
    }

    public static void printBoard(String[][] board) {
        for(int i = 0; i < board.length; i++) {
            System.out.println();
            for(int j = 0; j < board.length; j++) {
                System.out.print(" " + board[i][j]);
            }
        }
    }

    public static String hasGameEnded(String[][] board) {
        // linii
        for(int i = 0; i < board.length; i++) {
            if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                if(board[i][0].equals("X")) {
                    return "X won";
                } else if(board[i][0].equals("0")) {
                    return "0 won";
                }
            }
        }

        // coloane
        for(int i = 0; i < board.length; i++) {
            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                if(board[0][i].equals("X")) {
                    return "X won";
                } else if(board[0][i].equals("0")) {
                    return "0 won";
                }
            }
        }

        // diagonala 1 - stanga -> dreapta
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            if(board[0][0].equals("X")) {
                return "X won";
            } else if(board[0][0].equals("0")) {
                return "0 won";
            }
        }

        // diagonala 2 - dreapta -> stanga
        if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            if(board[0][2].equals("X")) {
                return "X won";
            } else if(board[0][2].equals("0")) {
                return "0 won";
            }
        }

        // verificam daca s-a terminat (daca avem macar 1 "_" nu s-a terminat)
        for(int i =0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if (board[i][j].equals("_")) {
                    return "not ended";
                }
            }
        }

        // daca am completat toate casutele, dar nimeni nu a castigat (niciuna din conditiile de mai sus nu e indeplinita), e draw
        return "draw";
    }
}
