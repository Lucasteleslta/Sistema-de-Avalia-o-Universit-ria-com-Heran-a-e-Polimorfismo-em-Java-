package universidade.prova;

public class ProvaUCB extends ProvaUniversidade {

    private static final double MEDIA_MINIMA_UCB = 7.0;
    private static final double PESO_PADRAO = 1.0;

    public ProvaUCB(double av1, double av2) {
        super(av1, av2, 0.0,
              PESO_PADRAO, PESO_PADRAO, PESO_PADRAO,
              MEDIA_MINIMA_UCB);
    }

    @Override
    public double calcularMedia() {
        if (realizouProvaFinal) {
            // AV3 substitui a menor nota entre AV1 e AV2
            double menorNota = Math.min(av1, av2);
            double maiorNota = Math.max(av1, av2);

            // Calcula com as duas maiores notas (AV3 substituiu a menor)
            return (maiorNota * pesoAV1 + av3 * pesoAV2) / (pesoAV1 + pesoAV2);
        }
        return (av1 * pesoAV1 + av2 * pesoAV2) / (pesoAV1 + pesoAV2);
    }

    @Override
    public ProvaFinalUniversidade getProvaFinalUniversidade() {
        return new ProvaAV3UCB(this);
    }

    @Override
    public String toString() {
        return String.format(
            "ProvaUCB [AV1=%.1f (peso=%.0f), AV2=%.1f (peso=%.0f), Média Mínima=%.0f]",
            av1, pesoAV1, av2, pesoAV2, mediaMinima
        );
    }
}
