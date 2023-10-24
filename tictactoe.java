import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class tictactoe {
    static String displayValue(int value) {
        if (value == 0) {
            return " ";
        } else if (value == 1) {
            return "O";
        } else {
            return "X"; // Empty cell
        }
    }

    public static void main(String[] args) {
        Integer turn = 0;
        int[] board = new int[9];
        ArrayList<String> history = new ArrayList<>();
        HashMap<Integer, Integer> cross_x = new HashMap<>();
        HashMap<Integer, Integer> cross_o = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            cross_x.put(i, 0);
            cross_o.put(i, 0);
        }

        while ((!cross_x.containsValue(3) || !cross_x.containsValue(3)) && (!cross_o.containsValue(3) || !cross_o.containsValue(3))) {
            // O = 0, X = 1
            Integer fill;
            HashMap<Integer, Integer> cross;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Move: ");

            String input = scanner.nextLine();

            if (history.contains(input)) {
                System.out.println("Move already made!");
                continue;
            }

            String[] move = input.split("");

            if (turn % 2 == 1) {
                fill = 2;
                cross = cross_x;
            } else {
                fill = 1;
                cross = cross_o;
            }

            Integer index;

            if (move[0].equals("a") && Integer.valueOf(move[1]) <= 3) {
                index = -1 + Integer.valueOf(move[1]);
                board[index] = fill;
                cross.put(Integer.valueOf(move[1]) - 1, cross.get(Integer.valueOf(move[1]) - 1) + 1);
                cross.put(3, cross.get(3) + 1);
                if (Integer.valueOf(move[1]).equals(1)) cross.put(6, cross.get(6) + 1);
                if (Integer.valueOf(move[1]).equals(3)) cross.put(7, cross.get(7) + 1);
                history.add(input);
            } else if (move[0].equals("b") && Integer.valueOf(move[1]) <= 3) {
                index = 2 + Integer.valueOf(move[1]);
                board[index] = fill;
                cross.put(Integer.valueOf(move[1]) - 1, cross.get(Integer.valueOf(move[1]) - 1) + 1);
                cross.put(4, cross.get(4) + 1);
                if (Integer.valueOf(move[1]).equals(2)) {
                    cross.put(6, cross.get(6) + 1);
                    cross.put(7, cross.get(7) + 1);
                }
                history.add(input);
            } else if (move[0].equals("c") && Integer.valueOf(move[1]) <= 3) {
                index = 5 + Integer.valueOf(move[1]);
                board[index] = fill;
                cross.put(Integer.valueOf(move[1]) - 1, cross.get(Integer.valueOf(move[1]) - 1) + 1);
                cross.put(5, cross.get(5) + 1);
                if (Integer.valueOf(move[1]).equals(3)) cross.put(6, cross.get(6) + 1);
                if (Integer.valueOf(move[1]).equals(1)) cross.put(7, cross.get(7) + 1);
                history.add(input);
            } else {
                System.out.println("Move invalid!");
                continue;
            }

            turn++;
            String display = String.format(
                    "-------------\n| %s | %s | %s |\n-------------\n| %s | %s | %s |\n-------------\n| %s | %s | %s |\n-------------",
                    displayValue(board[0]), displayValue(board[1]), displayValue(board[2]),
                    displayValue(board[3]), displayValue(board[4]), displayValue(board[5]),
                    displayValue(board[6]), displayValue(board[7]), displayValue(board[8]));
            System.out.println(display);
        }
        if (cross_o.containsValue(3)) System.out.println("O wins!");
        else System.out.println("X wins!");

    }
}