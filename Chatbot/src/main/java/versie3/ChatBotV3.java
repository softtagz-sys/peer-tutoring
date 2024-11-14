package versie3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;

public class ChatBotV3 {
    // Bestaande attributen
    private String naam;
    private Random random;
    private String[] antwoorden;
    private String[] zoekwoorden;
    private String[] specifiekeAntwoorden;

    private int vraagCount = 0;

    // Gespreksduur attributen
    private LocalDateTime startTijd;
    private LocalDateTime stopTijd;

    public ChatBotV3(String naam) {
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

        // Zoekwoorden en bijpassende antwoorden
        this.zoekwoorden = new String[]{
                "aanloggen", "traag", "scherm", "hangt", "kleuren", "trager", "geluid",
                "vooruit", "niet", "gisteren", "weekend", "geen idee", "oplossing",
                "geen", "zeker"
        };

        this.specifiekeAntwoorden = new String[]{
                "Probeer opnieuw aan te loggen, lost dat je probleem op?",
                "Herstarten van het systeem kan vele snelheidsproblemen oplossen. Heb je dat al geprobeerd?",
                /* overige antwoorden */
        };
    }

    public void startGesprek() {
        startTijd = LocalDateTime.now();
    }

    public void stopGesprek() {
        stopTijd = LocalDateTime.now();
    }

    private String berekenGespreksduur() {
        Duration duur = Duration.between(startTijd, stopTijd);
        return duur.getSeconds() + " sec";
    }

    public String antwoordOpVraag(String vraag) {
        vraagCount++;
        String reactie = "";

        if (vraagCount > 5) {
            reactie = "Zucht, typisch. ";
        }

        if (vraag.equalsIgnoreCase("stop")) {
            stopGesprek();
            return "Je hebt blijkbaar geen vragen meer. Ok, dan ben ik weg. De groeten van " + naam + "!\n" +
                    "Dit gesprek duurde " + berekenGespreksduur() + ".";
        } else if (vraag.length() < 4) {
            return "";
        }

        vraag = vraag.toLowerCase(Locale.ROOT);
        for (int i = 0; i < zoekwoorden.length; i++) {
            if (vraag.contains(zoekwoorden[i])) {
                return specifiekeAntwoorden[i];
            }
        }

        int index = random.nextInt(antwoorden.length);
        return reactie + antwoorden[index];
    }
}
