package deel1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input = 0;

        System.out.println("Conversie graden Celsius - Fahrenheit");
        System.out.println("======================================");

        do {
            System.out.println("Welke conversie wens je te doen?");
            System.out.println("1. Celsius naar Fahrenheit");
            System.out.println("2. Fahrenheit naar Celsius");
            System.out.println("0. Stoppen");
            System.out.print("Uw keuze: ");

            input = scanner.nextInt();

            if (input == 1){
                System.out.print("Geef de temperatuur in Celsius: ");
                double celsius = scanner.nextDouble();
                double fahrenheit = celsius * 9/5 + 32;
                System.out.println(celsius + "°C = " + fahrenheit + "°F");
            } else if (input == 2){
                System.out.print("Geef de temperatuur in Fahrenheit: ");
                double fahrenheit = scanner.nextDouble();
                double celsius = (fahrenheit - 32) * 5/9;
                System.out.println(fahrenheit + "°F = " + celsius + "°C");
            }

        }while (input != 0);
    }
}
