package versie1;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        ChatBotV1 bot = new ChatBotV1("Veronica");
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
