package universidade.prova;

public abstract class ProvaFinalUniversidade {

    protected double notaProvaFinal;
    protected double pesoProvaFinal;
    protected boolean realizouProva;
    protected ProvaUniversidade provaUniversidade;

    public ProvaFinalUniversidade(ProvaUniversidade provaUniversidade,
                                   double pesoProvaFinal) {
        this.provaUniversidade = provaUniversidade;
        this.pesoProvaFinal = pesoProvaFinal;
        this.notaProvaFinal = 0.0;
        this.realizouProva = false;
    }

    public abstract boolean habilitadoRealizarProva();

    public double getNotaProvaFinal() { return notaProvaFinal; }
    public void setNotaProvaFinal(double notaProvaFinal) {
        this.notaProvaFinal = notaProvaFinal;
        this.realizouProva = true;
        this.provaUniversidade.setRealizouProvaFinal(true);
    }

    public double getPesoProvaFinal() { return pesoProvaFinal; }
    public boolean isRealizouProva() { return realizouProva; }
    public ProvaUniversidade getProvaUniversidade() { return provaUniversidade; }
}
