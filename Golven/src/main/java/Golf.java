public class Golf {
    private double amplitude;
    private double frequentie;
    private double fase;

    public Golf() {
        this.amplitude = 1.0;
        this.frequentie = 1.0;
        this.fase = 0.0;
    }

    public void setAmplitude(double amplitude) {
        if (amplitude <= 0) {
            throw new IllegalArgumentException("Amplitude must be greater than 0");
        }
        this.amplitude = amplitude;
    }

    public void setFrequentie(double frequentie) {
        if (frequentie <= 0) {
            throw new IllegalArgumentException("Frequentie must be greater than 0");
        }
        this.frequentie = frequentie;
    }

    public void setFase(double fase) {
        this.fase = fase;
    }

    public double getYwaarde(double x) {
        return amplitude * Math.sin(frequentie * x + fase);
    }

    @Override
    public String toString() {
        String amplitudeStr = amplitude == 1.0 ? "" : String.format("%.1f * ", amplitude);
        String frequentieStr = frequentie == 1.0 ? "" : String.format("%.1f * ", frequentie);
        String faseStr = fase == 0.0 ? "" : (fase > 0 ? String.format("+ %.1f", fase) : String.format("- %.1f", -fase));
        return String.format("y = %ssin(%sx %s)", amplitudeStr, frequentieStr, faseStr).trim();
    }
}