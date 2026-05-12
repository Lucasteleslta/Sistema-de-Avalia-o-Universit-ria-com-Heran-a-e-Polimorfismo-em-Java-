package universidade.prova;

public class ProvaFinalFafifo extends ProvaFinalUniversidade {

    public ProvaFinalFafifo(ProvaUniversidade provaUniversidade) {
        super(provaUniversidade, 3.0);
    }

    /**
     * Na Fafifo, o aluno só faz a AV3 se ainda NÃO atingiu a média mínima.
     */
    @Override
    public boolean habilitadoRealizarProva() {
        return !provaUniversidade.aprovado();
    }

    @Override
    public void setNotaProvaFinal(double nota) {
        if (!habilitadoRealizarProva()) {
            System.out.println("[Fafifo] Aluno já aprovado — AV3 não é permitida.");
            return;
        }
        super.setNotaProvaFinal(nota);
        provaUniversidade.av3 = nota;
    }

    @Override
    public String toString() {
        if (realizouProva) {
            return String.format(
                "ProvaFinalFafifo [nota=%.1f (peso=%.0f), habilitado=%b]",
                notaProvaFinal, pesoProvaFinal, habilitadoRealizarProva()
            );
        }
        return String.format("ProvaFinalFafifo [não realizada, habilitado=%b]",
                             habilitadoRealizarProva());
    }
}
