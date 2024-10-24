import java.awt.Color;
import java.util.Random;

public class GolvenGrafiek {
    private Golf[] golven;
    private Random random;

    public GolvenGrafiek(int aantalGolven) {
        this.golven = new Golf[aantalGolven];
        this.random = new Random();
        maakGolven();
    }

    private void maakGolven() {
        for (int i = 0; i < golven.length; i++) {
            double amplitude = 0.1 + (4.0 - 0.1) * random.nextDouble();
            double frequentie = 0.1 + (4.0 - 0.1) * random.nextDouble();
            double fase = -1.0 + (1.0 - (-1.0)) * random.nextDouble();
            golven[i] = new Golf();
            golven[i].setAmplitude(amplitude);
            golven[i].setFrequentie(frequentie);
            golven[i].setFase(fase);
        }
    }

    public void tekenGolven() {
        GrafiekWindow window = new GrafiekWindow(10, 6);
        for (Golf golf : golven) {
            for (double x = -10; x <= 10; x += 0.01) {
                double y = golf.getYwaarde(x);
                window.tekenPunt(x, y, Color.BLUE);
            }
        }
        window.toon();
    }
}