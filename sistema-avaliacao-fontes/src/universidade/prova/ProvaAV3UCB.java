package universidade.prova;

public class ProvaAV3UCB extends ProvaFinalUniversidade {

    public ProvaAV3UCB(ProvaUniversidade provaUniversidade) {
        super(provaUniversidade, 1.0);
    }

    /**
     * Na UCB, o aluno pode fazer a AV3 mesmo já estando aprovado.
     * Portanto, qualquer aluno está habilitado a realizá-la.
     */
    @Override
    public boolean habilitadoRealizarProva() {
        return true;
    }

    @Override
    public void setNotaProvaFinal(double nota) {
        super.setNotaProvaFinal(nota);
        // Atualiza a AV3 na ProvaUCB para uso no cálculo da média
        provaUniversidade.av3 = nota;
    }

    @Override
    public String toString() {
        if (realizouProva) {
            double menorOriginal = Math.min(provaUniversidade.av1, provaUniversidade.av2);
            return String.format(
                "ProvaAV3UCB [nota=%.1f, substituiu nota=%.1f, habilitado=%b]",
                notaProvaFinal, menorOriginal, habilitadoRealizarProva()
            );
        }
        return String.format("ProvaAV3UCB [não realizada, habilitado=%b]",
                             habilitadoRealizarProva());
    }
}
