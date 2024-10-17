import java.util.Scanner;

public class Galgje3 {
    private static final String HANGMAN =
            "----- \n" +
                    "|     | \n" +
                    "|     O \n" +
                    "|    /|\\\n" +
                    "|     | \n" +
                    "|    / \\\n" +
                    "|       \n" +
                    "-------";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String teZoekenWoord = vraagWoord(scanner);
        maakSchermLeeg();
        speelGalgje(scanner, teZoekenWoord);
        scanner.close();
    }

    private static String vraagWoord(Scanner scanner) {
        String teZoekenWoord = "";
        while (true) {
            System.out.print("Geef een woord (minimaal 5 en maximaal 10 letters): ");
            teZoekenWoord = scanner.nextLine();
            if (teZoekenWoord.length() >= 5 && teZoekenWoord.length() <= 10) {
                break;
            } else {
                System.out.println("Het woord moet minimaal 5 en maximaal 10 letters lang zijn.");
            }
        }
        return teZoekenWoord;
    }

    private static void maakSchermLeeg() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    private static void speelGalgje(Scanner scanner, String teZoekenWoord) {
        StringBuilder geradenWoord = new StringBuilder(".".repeat(teZoekenWoord.length()));
        System.out.println("Het te zoeken woord: " + geradenWoord);

        int pogingen = 0;
        boolean geraden = false;
        while (pogingen < 8 && !geraden) {
            char gok = vraagLetter(scanner);
            pogingen++;
            updateGeradenWoord(teZoekenWoord, geradenWoord, gok);
            System.out.println("Het te zoeken woord: " + geradenWoord);
            toonHangman(pogingen);
            geraden = controleerWoord(teZoekenWoord, geradenWoord);
        }

        if (!geraden) {
            System.out.println("Helaas, je hebt het woord niet geraden. Het woord was: " + teZoekenWoord);
        }
    }

    private static char vraagLetter(Scanner scanner) {
        System.out.print("Raad een letter: ");
        return scanner.next().charAt(0);
    }

    private static void updateGeradenWoord(String teZoekenWoord, StringBuilder geradenWoord, char gok) {
        for (int i = 0; i < teZoekenWoord.length(); i++) {
            if (teZoekenWoord.charAt(i) == gok) {
                geradenWoord.setCharAt(i, gok);
            }
        }
    }

    private static void toonHangman(int pogingen) {
        System.out.println(HANGMAN.substring(0, Math.min(pogingen * 7, HANGMAN.length())));
    }

    private static boolean controleerWoord(String teZoekenWoord, StringBuilder geradenWoord) {
        if (geradenWoord.toString().equals(teZoekenWoord)) {
            System.out.println("Proficiat, je hebt het woord geraden!");
            return true;
        }
        return false;
    }
}