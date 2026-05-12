package universidade.prova.teste;

import universidade.prova.*;

public class Teste {

    public static void main(String[] args) {
        // Sistema para universidades
        System.out.println("SISTEMA DE AVALIAÇÃO PARA UNIVERSIDADES\n");
        System.out.println("Avaliação 01: AV1");
        System.out.println("Avaliação 02: AV2");
        System.out.println("Avaliação 03: AV3 ( Recuperação )");

        // UCB
        System.out.println("Universidade de exemplo: UCB Universidade Católica de Brasília\n");

        ProvaUCB provaUCB = new ProvaUCB(6.0, 5.0);
        System.out.println("Exemplos de média para UCB:");
        System.out.println(provaUCB);
        System.out.printf("Média (sem AV3): %.2f%n", provaUCB.calcularMedia());
        System.out.printf("Situação: %s%n%n", provaUCB.aprovado() ? "APROVADO" : "REPROVADO");

        // Aluno faz AV3 (pode fazer mesmo aprovado)
        ProvaFinalUniversidade av3UCB = provaUCB.getProvaFinalUniversidade();
        System.out.println("Exemplos de média para UCB: Aluno faz AV3:");
        System.out.println("Aluno está realizando AV3...");
        System.out.printf("Aluno está habilitado para AV3? Resposta: %b%n", av3UCB.habilitadoRealizarProva());
        av3UCB.setNotaProvaFinal(9.0);
        System.out.println("Qual o resultado da prova? Resposta:" + av3UCB);
        System.out.printf("Nova média (com a AV3) : %.2f%n", provaUCB.calcularMedia());
        System.out.printf("Situação final : %s%n", provaUCB.aprovado() ? "APROVADO" : "REPROVADO");

        System.out.println();

        // Recuperação
        System.out.println("  Recuperação\n");

        // Cenário 1: aluno reprovado que faz AV3
        System.out.println("Cenário 1: Aluno reprovado realiza AV3\n");
        ProvaFafifo provaFafifo1 = new ProvaFafifo(4.0, 5.0);
        System.out.println(provaFafifo1);
        System.out.printf("Média do aluno (sem AV3): %.2f%n", provaFafifo1.calcularMedia());
        System.out.printf("Situação: %s%n", provaFafifo1.aprovado() ? "APROVADO" : "REPROVADO");

        ProvaFinalUniversidade av3Fafifo1 = provaFafifo1.getProvaFinalUniversidade();
        System.out.printf("%n Aluno está habilitado para AV3? Resposta: %b%n", av3Fafifo1.habilitadoRealizarProva());
        av3Fafifo1.setNotaProvaFinal(8.0);
        System.out.println("  " + av3Fafifo1);
        System.out.printf("Média (com AV3): %.2f%n", provaFafifo1.calcularMedia());
        System.out.printf("Situação final: %s%n", provaFafifo1.aprovado() ? "APROVADO" : "REPROVADO");

        System.out.println();

        // Cenário 2: aluno já aprovado não pode fazer AV3
        System.out.println("Cenário 2: Aluno aprovado: não pode realizar AV3\n");
        ProvaFafifo provaFafifo2 = new ProvaFafifo(7.0, 8.0);
        System.out.println(provaFafifo2);
        System.out.printf("Média (sem AV3): %.2f%n", provaFafifo2.calcularMedia());
        System.out.printf("Situação: %s%n", provaFafifo2.aprovado() ? "APROVADO" : "REPROVADO");

        ProvaFinalUniversidade av3Fafifo2 = provaFafifo2.getProvaFinalUniversidade();
        System.out.printf("%n Aluno está habilitado para AV3? Resposta: %b%n", av3Fafifo2.habilitadoRealizarProva());
        av3Fafifo2.setNotaProvaFinal(9.0); // tentativa bloqueada
        System.out.printf("Média final: %.2f%n", provaFafifo2.calcularMedia());
        System.out.printf("Situação final: %s%n", provaFafifo2.aprovado() ? "APROVADO" : "REPROVADO");
;
        System.out.println("FIM DA SIMULAÇÃO ");
    }
}
