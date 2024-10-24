public class GolfTest {
    public static void main(String[] args) {
        // Test the Golf class
        Golf golf1 = new Golf();
        golf1.setAmplitude(10);
        golf1.setFrequentie(3);
        golf1.setFase(1);
        System.out.println(golf1); // Expected: y = 10.0 * sin(3.0 * x + 1.0)

        Golf golf2 = new Golf();
        golf2.setAmplitude(1);
        golf2.setFrequentie(2);
        golf2.setFase(0);
        System.out.println(golf2); // Expected: y = sin(2.0 * x)

        // Test invalid values
        try {
            golf1.setAmplitude(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected: Amplitude must be greater than 0
        }

        try {
            golf1.setFrequentie(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected: Frequentie must be greater than 0
        }

        // Print waves with varying amplitude
        for (double amplitude = 1.0; amplitude <= 5.0; amplitude += 0.5) {
            Golf golf = new Golf();
            golf.setAmplitude(amplitude);
            golf.setFrequentie(2);
            golf.setFase(0);
            System.out.println(golf);
        }
    }
}