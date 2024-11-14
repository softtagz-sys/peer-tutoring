package versie1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ChatBotV1 {
    private String naam;
    private Random random;
    private String[] antwoorden;

    public ChatBotV1(String naam) {
        this.naam = naam;
        this.random = new Random();
        this.antwoorden = new String[]{
                "Ok, probeer eerst al eens te herstarten",
                "Kan je het probleem eens herformuleren?",
                "En is dat al lang zo?",
                "Waarom heb je ons niet eerder gecontacteerd?",
                "Ik denk dat je dat zelf wel kan oplossen, niet?",
                "Die vraag heb ik nog niet vaak gehad!",
                "Sorry, ik was even bezig, kan je de vraag eens herhalen?",
                "Aha, gekend probleem, ik zoek het op en laat je iets weten.",
                "Sorry, daar heb ik niet direct een antwoord op. Wat nu?",
                "En dan?",
                "Dat zal wel, maar er zijn ergere dingen he.",
                "Hmm, die moet ik opzoeken. En wanneer deed dat zich juist voor?"
        };
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String tijdstip = LocalDateTime.now().format(formatter);
        return tijdstip + "\nHallo, ik ben chatbot " + naam + ", stel me een vraag en ik geef je een oplossing!";
    }

    public String antwoordOpVraag(String vraag) {
        if (vraag.equalsIgnoreCase("stop")) {
            return "Je hebt blijkbaar geen vragen meer. Ok, dan ben ik weg. De groeten van " + naam;
        } else if (vraag.length() < 4) {
            return "";
        } else {
            int index = random.nextInt(antwoorden.length);
            return antwoorden[index];
        }
    }
}
