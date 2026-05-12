package universidade.prova;

public abstract class ProvaUniversidade {

    protected double av1;
    protected double av2;
    protected double av3;

    protected double pesoAV1;
    protected double pesoAV2;
    protected double pesoAV3;

    protected double mediaMinima;
    protected boolean realizouProvaFinal;

    public ProvaUniversidade(double av1, double av2, double av3,
                              double pesoAV1, double pesoAV2, double pesoAV3,
                              double mediaMinima) {
        this.av1 = av1;
        this.av2 = av2;
        this.av3 = av3;
        this.pesoAV1 = pesoAV1;
        this.pesoAV2 = pesoAV2;
        this.pesoAV3 = pesoAV3;
        this.mediaMinima = mediaMinima;
        this.realizouProvaFinal = false;
    }

    public abstract double calcularMedia();

    public abstract ProvaFinalUniversidade getProvaFinalUniversidade();

    public boolean aprovado() {
        return calcularMedia() >= mediaMinima;
    }

    // Getters e Setters
    public double getAv1() { return av1; }
    public double getAv2() { return av2; }
    public double getAv3() { return av3; }
    public double getPesoAV1() { return pesoAV1; }
    public double getPesoAV2() { return pesoAV2; }
    public double getPesoAV3() { return pesoAV3; }
    public double getMediaMinima() { return mediaMinima; }
    public boolean isRealizouProvaFinal() { return realizouProvaFinal; }
    public void setRealizouProvaFinal(boolean realizouProvaFinal) {
        this.realizouProvaFinal = realizouProvaFinal;
    }
}
