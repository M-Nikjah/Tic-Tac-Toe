import java.util.InputMismatchException;
import java.util.Scanner;

public class Play {

    Scanner scanner = new Scanner(System.in);

    Play() {
        System.out.println("Player 1: Enter your name: ");
        String p1_name = scanner.next();
        String p1_marker;
        while (true) {
            System.out.println("Choose your marker of choice: ");
            p1_marker = scanner.next();
            if (!p1_marker.equals("x") && !p1_marker.equals("X") && !p1_marker.equals("o") && !p1_marker.equals("O")) {
                System.out.println("Wrong choice!");
            } else {
                break;
            }
        }
        System.out.println("Player 2: Enter your name: ");
        String p2_name = scanner.next();
        while (true) {
            System.out.println("Choose your marker of choice: ");
            String p2_marker = scanner.next();
            if (!p2_marker.equals("x") && !p2_marker.equals("X") && !p2_marker.equals("o") && !p2_marker.equals("O") ||
            p2_marker.equals(p1_marker)) {
                System.out.println("Wrong choice!");
            } else {
                break;
            }
        }
    }

    public char whoseTurn(int i) {
        if (i % 2 == 0) {
            return 'X';
        } else {
            return 'O';
        }
    }

    public void move(char turn) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                if (i < 0 || i > 3 || j < 0 || j > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (Field.field[3 - j][i - 1] == '_') {
                    Field.field[3 - j][i - 1] = turn;
                    Field.draw();
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (InputMismatchException error) {
                System.out.println("You should enter numbers!");
                scanner.next();
            }
        }
    }

    public boolean playAgain() {
        System.out.println("Do you want to play again(Y/N)?");
        String  ans = scanner.next();
        if (ans.equals("Y") || ans.equals("y")) {
            return true;
        } else if (ans.equals("N") || ans.equals("n")) {
            return false;
        } else {
            System.out.println("Wrong answer!");
            playAgain();
        }
        return true;
    }
}
