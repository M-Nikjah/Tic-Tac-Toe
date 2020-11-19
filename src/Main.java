public class Main {
    public static void main(String[] args) {
        boolean finish;
        boolean again;
        do {
            Play play = new Play();
            Field gameField = new Field();
            int i = 0;
            do {
                char turn = play.whoseTurn(i);
                play.move(turn);
                finish = gameField.checkField();
                i++;
            } while (!finish);
            again = play.playAgain();
        } while (again);
    }
}
