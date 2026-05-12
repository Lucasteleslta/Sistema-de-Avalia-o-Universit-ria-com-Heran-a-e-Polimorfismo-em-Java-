package universidade.prova;

public class ProvaFafifo extends ProvaUniversidade {

    private static final double MEDIA_MINIMA_FAFIFO = 6.0;
    private static final double PESO_AV1 = 1.0;
    private static final double PESO_AV2 = 1.0;
    private static final double PESO_AV3 = 3.0;

    public ProvaFafifo(double av1, double av2) {
        super(av1, av2, 0.0,
              PESO_AV1, PESO_AV2, PESO_AV3,
              MEDIA_MINIMA_FAFIFO);
    }

    @Override
    public double calcularMedia() {
        if (realizouProvaFinal) {
            // AV3 é somada às outras notas com seu peso
            return (av1 * pesoAV1 + av2 * pesoAV2 + av3 * pesoAV3)
                   / (pesoAV1 + pesoAV2 + pesoAV3);
        }
        // Sem AV3, a média considera apenas AV1 e AV2
        return (av1 * pesoAV1 + av2 * pesoAV2) / (pesoAV1 + pesoAV2);
    }

    @Override
    public ProvaFinalUniversidade getProvaFinalUniversidade() {
        return new ProvaFinalFafifo(this);
    }

    @Override
    public String toString() {
        return String.format(
            "ProvaFafifo [AV1=%.1f (peso=%.0f), AV2=%.1f (peso=%.0f), AV3 peso=%.0f, Média Mínima=%.0f]",
            av1, pesoAV1, av2, pesoAV2, pesoAV3, mediaMinima
        );
    }
}
