import java.util.Arrays;

public class Field {

    static char[][] field = new char[3][3];

    Field() {
        for (char[] row: field)
            Arrays.fill(row, '_');
        draw();
    }

    public static void draw() {
        System.out.println("---------");
        System.out.println("| " + field[0][0] + " " + field[0][1] + " " + field[0][2] + " |");
        System.out.println("| " + field[1][0] + " " + field[1][1] + " " + field[1][2] + " |");
        System.out.println("| " + field[2][0] + " " + field[2][1] + " " + field[2][2] + " |");
        System.out.println("---------");
    }

    public boolean checkField() {
        boolean xWins = false;
        boolean oWins = false;
        int sum;

        // check rows
        for (int i = 0; i < 3; i++) {
            sum = field[i][0] + field[i][1] + field[i][2];
            if (sum == 264) {
                xWins = true;
            } else if (sum == 237) {
                oWins = true;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            sum = field[0][i] + field[1][i] + field[2][i];
            if (sum == 264) {
                xWins = true;
            } else if (sum == 237) {
                oWins = true;
            }
        }

        // check main diagonal
        sum = field[0][0] + field[1][1] + field[2][2];
        if (sum == 264) {
            xWins = true;
        } else if (sum == 237) {
            oWins = true;
        }

        // check second diagonal
        sum = field[0][2] + field[1][1] + field[2][0];
        if (sum == 264) {
            xWins = true;
        } else if (sum == 237) {
            oWins = true;
        }

        int blankSpaces = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == '_') {
                    blankSpaces++;
                }
            }
        }

        if (xWins) {
            System.out.println("X wins");
            return true;
        } else if (oWins) {
            System.out.println("O wins");
            return true;
        } else if (blankSpaces == 0) {
            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }
}
