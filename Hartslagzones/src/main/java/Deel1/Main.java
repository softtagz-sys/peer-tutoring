package Deel1;

import java.util.Scanner;

public class Main {
    private static final int HEART_RATE_MULTIPLIER = 4;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double hrr = 0;
            double restingHeartRate = 0;
            double maxHeartRate = 0;

            // Step 1: Ask if HRR is known
            if (askYesNoQuestion(scanner, "Ken je je HRR? (J/N): ")) {
                hrr = getDoubleInput(scanner, "Geef je HRR: ");
            }

            // Step 1: Ask if resting heart rate is known
            if (askYesNoQuestion(scanner, "Ken je je rusthartslag? (J/N): ")) {
                restingHeartRate = getDoubleInput(scanner, "Geef je rusthartslag: ");
            } else {
                // Step 2: Calculate resting heart rate
                restingHeartRate = countHeartRate(15, scanner);
            }

            // Step 3: Calculate maximum heart rate
            System.out.println("==============================================");
            System.out.println("We berekenen nu je maximale hartslag.");
            System.out.println("Ga naar buiten en doe de volgende oefeningen:");
            System.out.println("Interval 1: Ren 30 seconden op volle snelheid.");
            System.out.println("Herstelperiode 1: Rust 60 seconden.");
            System.out.println("Interval 2: Ren 30 seconden op volle snelheid.");
            System.out.println("Herstelperiode 2: Rust 60 seconden.");
            System.out.println("Interval 3: Ren 60 seconden op volle snelheid.");
            System.out.println("Tel je hartslag gedurende 15 seconden.");

            waitForUserInput(scanner, "Typ 'OK' als je klaar bent.");
            maxHeartRate = countHeartRate(15, scanner);

            // Step 4: Calculate HRR if not known
            if (hrr == 0) {
                hrr = maxHeartRate - restingHeartRate;
            }

            // Step 5: Display HRR
            System.out.println("Je HRR is: " + hrr);

            // Step 6: Determine heart rate zone
            int zone = (int) getDoubleInput(scanner, "In welke zone wil je trainen (1-5)? ");
            double lowerLimit = calculateHeartRateZone(restingHeartRate, hrr, zone, 0.5);
            double upperLimit = calculateHeartRateZone(restingHeartRate, hrr, zone, 0.6);
            System.out.println("Je ideale hartslagzone is tussen " + lowerLimit + " en " + upperLimit);
        }
    }

    private static boolean askYesNoQuestion(Scanner scanner, String question) {
        String choice;
        do {
            System.out.print(question);
            choice = scanner.nextLine().trim().toUpperCase();
        } while (!choice.equals("J") && !choice.equals("N"));
        return choice.equals("J");
    }

    private static double getDoubleInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Ongeldige invoer. Probeer het opnieuw: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static void waitForUserInput(Scanner scanner, String prompt) {
        while (!scanner.nextLine().trim().equalsIgnoreCase("OK")) {
            System.out.println(prompt);
        }
    }

    private static double countHeartRate(int seconds, Scanner scanner) {
        waitForUserInput(scanner, "Ga rustig zitten en adem 10x diep in en uit. Typ 'OK' als je klaar bent.");
        System.out.println("Tel je hartslag gedurende " + seconds + " seconden.");
        countdown(seconds);
        return getDoubleInput(scanner, "Geef het aantal slagen in: ") * HEART_RATE_MULTIPLIER;
    }

    private static void countdown(int seconds) {
        for (int i = seconds; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Stop");
    }

    private static double calculateHeartRateZone(double restingHeartRate, double hrr, int zone, double percentage) {
        return restingHeartRate + hrr * percentage;
    }
}