# Sistema de Avaliação de Universidades

Simulação orientada a objetos do processo de avaliação de alunos em duas instituições de ensino superior:

---

## Tecnologias

- Java 21
- Sem dependências externas

---

## Estrutura de Pacotes

```
src/
└── universidade/
    └── prova/
        ├── ProvaUniversidade.java        # Superclasse abstrata
        ├── ProvaFinalUniversidade.java   # Classe abstrata de prova final
        ├── ProvaUCB.java                 # Regras da UCB
        ├── ProvaFafifo.java              # Regras da Fafifo
        ├── ProvaAV3UCB.java              # AV3 da UCB
        ├── ProvaFinalFafifo.java         # AV3 da Fafifo
        └── teste/
            └── Teste.java               # Classe principal (main)
```

---

## Regras de Negócio

### UCB
| Item | Regra |
|---|---|
| Pesos | AV1, AV2, AV3 = 1 |
| Média mínima | 7,0 |
| AV3 | Substitui a menor nota entre AV1 e AV2 |
| Habilitação para AV3 | Qualquer aluno (mesmo aprovado) |

### recuperação
| Item | Regra |
|---|---|
| Pesos | AV1=1, AV2=1, AV3=3 |
| Média mínima | 6,0 |
| AV3 | Somada às demais notas com peso 3 |
| Habilitação para AV3 | Somente alunos **não** aprovados |

---

## Como Executar

### Pré-requisitos
- JDK 21 ou superior instalado — [adoptium.net](https://adoptium.net)

### Via terminal

```bash
# Compilar (dentro da pasta src/)
javac universidade/prova/*.java universidade/prova/teste/Teste.java

# Executar
java universidade.prova.teste.Teste
```

## Conceitos de POO Aplicados

- **Herança** — `ProvaUCB` e `ProvaFafifo` estendem `ProvaUniversidade`; `ProvaAV3UCB` e `ProvaFinalFafifo` estendem `ProvaFinalUniversidade`
- **Abstração** — métodos `calcularMedia()`, `getProvaFinalUniversidade()` e `habilitadoRealizarProva()` são abstratos
- **Polimorfismo** — `aprovado()` chama `calcularMedia()` sem saber qual subclasse está em uso
- **Encapsulamento** — atributos protegidos, acesso via getters/setters

---
