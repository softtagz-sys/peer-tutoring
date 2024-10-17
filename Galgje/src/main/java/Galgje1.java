import java.util.Scanner;

public class Galgje1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String teZoekenWoord = "";

        // Vraag om een woord totdat het aan de voorwaarden voldoet
        while (true) {
            System.out.print("Geef een woord (minimaal 5 en maximaal 10 letters): ");
            teZoekenWoord = scanner.nextLine();
            if (teZoekenWoord.length() >= 5 && teZoekenWoord.length() <= 10) {
                break;
            } else {
                System.out.println("Het woord moet minimaal 5 en maximaal 10 letters lang zijn.");
            }
        }

        // Maak het scherm leeg
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }

        // Toon puntjes aan de speler
        System.out.println("Het te zoeken woord: " + ".".repeat(teZoekenWoord.length()));

        // Speler mag nu gokken
        int pogingen = 0;
        boolean geraden = false;
        while (pogingen < 5 && !geraden) {
            System.out.print("Doe een gok: ");
            String gok = scanner.nextLine();
            pogingen++;
            if (gok.equalsIgnoreCase(teZoekenWoord)) {
                geraden = true;
                System.out.println("Proficiat, je hebt het woord geraden in " + pogingen + " beurten!");
            } else {
                System.out.println("Fout!");
            }
        }

        if (!geraden) {
            System.out.println("Helaas, je hebt het woord niet geraden. Het woord was: " + teZoekenWoord);
        }

        scanner.close();
    }
}