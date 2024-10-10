package Deel2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String level;
        int day;

        // Vraag de gebruiker of hij beginner of gevorderde is
        while (true) {
            System.out.print("Bent u een beginner of gevorderde? (B/G): ");
            level = scanner.nextLine().trim().toUpperCase();
            if (level.equals("B") || level.equals("G")) {
                break;
            } else {
                System.out.println("Ongeldige invoer. Voer 'B' voor beginner of 'G' voor gevorderde in.");
            }
        }

        // Vraag de hoeveelste dag hij dit uitvoert
        System.out.print("Hoeveelste dag voert u dit uit?: ");
        day = scanner.nextInt();

        // Bepaal de schema's
        if (level.equals("B")) {
            printBeginnerSchema(day);
        } else {
            printGevorderdeSchema(day);
        }
    }

    private static void printBeginnerSchema(int day) {
        double factor = 1 + (day - 1) * 0.1;
        int part1 = (int) (10 * factor);
        int part2 = 20;
        int part4 = (int) (40 * factor);
        int part5 = (int) (10 * factor);

        System.out.println("Beginner Dag " + day + ":");
        System.out.println("1. loop tss 151 en 177 : " + "*".repeat(part1));
        System.out.println("2. Loop tss 177 en 190 : " + "-".repeat(part2));
        System.out.println("3. Wandel tot maximale hartslag 151");
        System.out.println("4. Wandel tss 125 en 151 : " + "-".repeat(part4));
        System.out.println("5. Wandel tss 138 en 151 : " + "*".repeat(part5));
    }

    private static void printGevorderdeSchema(int day) {
        double factor = 1 + (day - 1) * 0.1;
        int part1 = (int) (20 * factor);
        int part2 = 30;
        int part4 = (int) (40 * factor);
        int part5 = (int) (10 * factor);

        System.out.println("Gevorderde Dag " + day + ":");
        System.out.println("1. loop tss 151 en 177 : " + "*".repeat(part1));
        System.out.println("2. Loop tss 177 en 190 : " + "-".repeat(part2));
        System.out.println("3. Wandel tot maximale hartslag 151");
        System.out.println("4. Wandel tss 125 en 151 : " + "-".repeat(part4));
        System.out.println("5. Wandel tss 138 en 151 : " + "*".repeat(part5));
    }
}