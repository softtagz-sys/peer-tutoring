package versie2;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        ChatBotV2 bot = new ChatBotV2("Veronica");
        bot.startGesprek();
        System.out.println(bot);

        Scanner scanner = new Scanner(System.in);
        String vraag;

        System.out.println("Tik \"stop\" om te eindigen");

        do {
            System.out.print("Uw vraag: ");
            vraag = scanner.nextLine();
            String antwoord = bot.antwoordOpVraag(vraag);
            if (!antwoord.isEmpty()) {
                System.out.println(antwoord);
            }
        } while (!vraag.equalsIgnoreCase("stop"));

        scanner.close();
    }
}

