package versie3;

import versie2.ChatBotV2;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        ChatBotV3 bot = new ChatBotV3("Veronica");
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

