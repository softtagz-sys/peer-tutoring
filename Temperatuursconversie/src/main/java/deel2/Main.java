package deel2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputBeginWaarde = 0;
        double inputEindWaarde = 0;
        double inputStapWaarde = 0;

        System.out.println("Conversie graden Celsius - Fahrenheit");
        System.out.println("======================================");

        System.out.println("Geef de begintemperatuur in Celsius: ");
        inputBeginWaarde = scanner.nextDouble();
        System.out.println("Geef de eindtemperatuur in Celsius: ");
        inputEindWaarde = scanner.nextDouble();
        if (inputBeginWaarde > inputEindWaarde) {
            System.out.println("De begintemperatuur moet kleiner zijn dan de eindtemperatuur.");
            System.exit(0);
        }

        System.out.println("Geef de stapwaarde: ");
        inputStapWaarde = scanner.nextDouble();

        for (double celsius = inputBeginWaarde; celsius <= inputEindWaarde; celsius += inputStapWaarde) {
            double fahrenheit = celsius * 9/5 + 32;
            System.out.println(celsius + "°C = " + fahrenheit + "°F");
        }

    }
}
